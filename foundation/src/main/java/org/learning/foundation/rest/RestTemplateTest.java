package org.learning.foundation.rest;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;

public class RestTemplateTest {
    public static void main(String[] args) throws Exception {
        RestTemplateTest test = new RestTemplateTest();
//        test.getTSVLink();
        test.getTSVFile();
        System.out.println("done");
    }

    public List<String> computeFailTSV() throws Exception {
        // step 1: 读取所有
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/sequences.fasta"));
        List<String> all = new LinkedList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith(">")) {
                String sequence = line + "\n" + bufferedReader.readLine();
                all.add(sequence);
            }
        }
        bufferedReader.close();
        System.out.println("all size: " + all.size());

        // step 2: 读取成功的
        List<String> success = new LinkedList<>();
        bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/sequencesResult.fasta"));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith(">")) {
                String sequence = line + "\n" + bufferedReader.readLine();
                success.add(sequence);
            }
        }
        bufferedReader.close();
        System.out.println("success size: " + success.size());

        // step 3: 计算失败的
        if (CollectionUtils.isEmpty(success)) {
            return all;
        }
        return success.stream().filter(t -> !all.contains(t)).collect(Collectors.toList());
    }

    public void getTSVFile() throws Exception {
        // step 1: 读取链接
        List<String> urls = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/sequencesTempResult.fasta"));
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith(">")) {
                bufferedReader.readLine();
                urls.add(bufferedReader.readLine());
            }
        }
        bufferedReader.close();

        System.out.println(urls.size());


        // step 2: 聚合
        ExecutorCompletionService<byte[]> ecs = new ExecutorCompletionService<>(Executors.newFixedThreadPool(16));
        List<Future<byte[]>> tasks = urls.stream().map(url -> ecs.submit(() -> {
                    try {
                        return IOUtils.toByteArray(new URL(url));
                    } catch (IOException e) {
                        e.printStackTrace();
                        return null;
                    }
                }))
                .collect(Collectors.toList());


        int i = 0;
        for (Future<byte[]> task : tasks) {
            byte[] bytes = ecs.take().get();
            if (!ObjectUtils.isEmpty(bytes)) {

                System.out.println(i++);
            }
        }


    }

    public void getTSVLink() throws Exception {
        // step 1: 读取配置
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/secquencesTemp.fasta"));
        List<String> sequences = new LinkedList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith(">")) {
                String sequence = line + "\n" + bufferedReader.readLine();
                sequences.add(sequence);
            }
        }
        bufferedReader.close();

        // step 2: 异步执行任务
        ExecutorCompletionService<SequenceResult> executorCompletionService = new ExecutorCompletionService<>(Executors.newFixedThreadPool(16));
        List<Future<SequenceResult>> futures = sequences.stream()
                .map(sequence -> executorCompletionService.submit(new SequenceJob(sequence)))
                .collect(Collectors.toList());

        List<SequenceResult> results = futures.stream()
                .map(future -> {
                    SequenceResult sequenceResult;
                    try {
                        sequenceResult = executorCompletionService.take().get();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        return null;
                    } catch (ExecutionException e) {
                        return null;
                    }
                    return sequenceResult;
                })
                .filter(Objects::nonNull)
                .collect(Collectors.toList());


        // step 3: 输出结果
        StringBuilder sb = new StringBuilder();
        results.forEach(result -> {
            sb.append(result.getSequence()).append("\n");
            sb.append("https://www.ebi.ac.uk/Tools/services/rest/iprscan5/result/").append(result.getJobId()).append("/tsv").append("\n");
        });
        System.out.println(sb);

        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yangchen/Downloads/sequencesTempResult.fasta");
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();
    }


    public String submitJob(String sequence) {
        String title = "internal-" + new Date().getTime() + "-" + new Random().nextInt(100);
        String param = "email=interpro-team@ebi.ac.uk&title=" + title + "&sequence=" + sequence + "&appl=TIGRFAM&appl=SFLD&appl=Panther&appl=HAMAP&appl=PrositeProfiles&appl=PrositePatterns&appl=SMART&appl=CDD&appl=PRINTS&appl=PfamA&appl=PIRSF&appl=SuperFamily&appl=Gene3d&appl=Phobius&appl=SignalP&appl=Coils&appl=MobiDBLite&appl=TMHMM&appl=SignalP_EUK&appl=SignalP_GRAM_POSITIVE&appl=SignalP_GRAM_NEGATIVE&goterms=true&pathways=true";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
        HttpEntity<String> request = new HttpEntity<>(param, headers);
        return new RestTemplate().postForObject("https://www.ebi.ac.uk/Tools/services/rest/iprscan5/run", request, String.class);
    }

    private String excetAccession(String jobId) {
        String result = new RestTemplate().getForObject("https://www.ebi.ac.uk/Tools/services/rest/iprscan5//result/" + jobId + "/json", String.class);

        if (!StringUtils.isEmpty(result)) {
            JSONObject json = JSON.parseObject(result);
            if (!ObjectUtils.isEmpty(json)) {
                JSONArray results = json.getJSONArray("results");
                if (!ObjectUtils.isEmpty(results)) {
                    JSONArray matches = results.getJSONObject(0).getJSONArray("matches");
                    if (!ObjectUtils.isEmpty(matches)) {
                        for (int i = 0; i < matches.size(); i++) {
                            JSONObject match = matches.getJSONObject(i);
                            if (!ObjectUtils.isEmpty(match)) {
                                JSONObject signature = match.getJSONObject("signature");
                                if (!ObjectUtils.isEmpty(signature)) {
                                    JSONObject entry = signature.getJSONObject("entry");
                                    if (!ObjectUtils.isEmpty(entry)) {
                                        return "http://www.ebi.ac.uk/interpro//entry/interpro/" + entry.getString("accession");
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return null;
    }


    private class SequenceJob implements Callable<SequenceResult> {
        private String squence;

        public SequenceJob(String squence) {
            this.squence = squence;
        }


        @Override
        public SequenceResult call() {
            SequenceResult result = new SequenceResult();
            result.setSequence(squence);

            try {
                String jobId = submitJob(squence);
                result.setJobId(jobId);
                return result;
            } catch (Exception e) {
                e.printStackTrace();
                return result;
            }
        }

    }

    @Data
    @ToString
    @AllArgsConstructor
    @NoArgsConstructor
    private class SequenceResult {
        private String sequence;
        private String jobId;
    }
}
