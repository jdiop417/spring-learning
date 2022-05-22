package org.learning.foundation.rest;

import com.google.common.base.Stopwatch;
import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.ArrayUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.client.RestTemplate;

import java.io.*;
import java.net.URL;
import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class CompletableFutureDemo {

    File destinationFile = new File("/Users/yangchen/Downloads/sequencesTempResult.tsv");
    ExecutorService executor = Executors.newFixedThreadPool(Runtime.getRuntime().availableProcessors());


    public static void main(String[] args) throws Exception {
        CompletableFutureDemo test = new CompletableFutureDemo();
        test.getTSVAsync3();
        System.out.println("done");
    }

    public void getTSVAsync() throws Exception {

        // step 1: 读取链接
        CompletableFuture.supplyAsync(() -> {
                    try {
                        List<String> urls = new LinkedList<>();
                        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/sequencesResult.fasta"));
                        int i = 0;
                        while (bufferedReader.ready()) {
                            String line = bufferedReader.readLine();
                            if (line.startsWith(">")) {
                                bufferedReader.readLine();
                                String url = bufferedReader.readLine();
                                urls.add(url);
                                i++;
                                System.out.println("add url" + i + ": " + url);
                            }
                        }
                        bufferedReader.close();
                        return urls;
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }
                })
                // step 2: 下载文件
                .thenComposeAsync(urls -> CompletableFuture.supplyAsync(() -> {
                    AtomicInteger i = new AtomicInteger(0);
                    return urls.stream().map(url -> {
                        try {
                            byte[] bytes = IOUtils.toByteArray(new URL(url));
                            return bytes;
                        } catch (IOException e) {
                            e.printStackTrace();
                            System.out.println("downloaded url" + i.getAndIncrement() + " fail: " + url);
                            return null;
                        }
                    }).filter(Objects::nonNull).collect(Collectors.toList());
                }), executor)
                // step 3: 写文件
                .thenApply(bytes -> {
                    int i = 0;
                    for (byte[] b : bytes) {
                        try {
                            System.out.println("writing: " + i);
                            FileUtils.writeByteArrayToFile(destinationFile, b, true);
                            System.out.println(i++);

                        } catch (IOException e) {
                            throw new RuntimeException(e);
                        }
                    }
                    return i;
                }).whenComplete((r, throwable) -> {
                    System.out.println(r);
                    System.out.println("done");
                });
    }


    public void getTSVAsync2() throws Exception {
        List<String> urls = new LinkedList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/hhhhhhhhh.fasta"));
        while (bufferedReader.ready()) {
            String url = bufferedReader.readLine();
            if (StringUtils.isNotBlank(url) && !url.contains("null")) {
                urls.add(url);
                System.out.println("add url: " + url);
            }
        }
        bufferedReader.close();



        List<CompletableFuture<byte[]>> files = urls.stream()
                .filter(StringUtils::isNotBlank)
                .map(url -> CompletableFuture.supplyAsync(() -> download(url), executor))
                .collect(Collectors.toList());


        CompletableFuture.anyOf(files.toArray(new CompletableFuture[0])).get();

        int i = 0;
        for (CompletableFuture<byte[]> file : files) {
            byte[] bytes = file.get();
            if (ArrayUtils.isEmpty(bytes)) {
                continue;
            }
            System.out.println("writing: " + i++);
            FileUtils.writeByteArrayToFile(destinationFile, file.join(), true);
        }

    }

    public void getTSVAsync3() throws Exception {

        Stopwatch stopwatch = Stopwatch.createStarted();
        // step 1: 读取配置
        BufferedReader bufferedReader = new BufferedReader(new FileReader("/Users/yangchen/Downloads/sequences.fasta"));
        List<String> sequences = new LinkedList<>();
        while (bufferedReader.ready()) {
            String line = bufferedReader.readLine();
            if (line.startsWith(">")) {
                String sequence = line + "\n" + bufferedReader.readLine();
                sequences.add(sequence);
            }
        }
        bufferedReader.close();

        // step 2: 提交任务
        List<CompletableFuture<String>> jobs = sequences.stream()
                .map(sequence -> CompletableFuture.supplyAsync(() -> submitJob(sequence), executor))
                .collect(Collectors.toList());

        // step 3: 获取结果

        CompletableFuture.allOf(jobs.toArray(new CompletableFuture[0])).get();
        List<String> urls = jobs.stream()
                .map(CompletableFuture::join)
                .map(jobId -> "https://www.ebi.ac.uk/Tools/services/rest/iprscan5/result/" + jobId + "/tsv")
                .collect(Collectors.toList());

        // step 4: 下载结果
        StringBuilder sb = new StringBuilder();
        for (String url : urls) {
            System.out.println(url);
            sb.append(url).append("\n");
        }
        FileOutputStream fileOutputStream = new FileOutputStream("/Users/yangchen/Downloads/hhhhhhhhh.fasta");
        fileOutputStream.write(sb.toString().getBytes());
        fileOutputStream.close();
        System.out.println(stopwatch.stop().elapsed(TimeUnit.MINUTES));
    }

    private byte[] download(String url) {
        try {
            return IOUtils.toByteArray(new URL(url));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("downloaded " + url + " fail ");
            return null;
        }
    }

    public String submitJob(String sequence) {
        try {
            String title = "internal-" + new Date().getTime() + "-" + new Random().nextInt(100);
            String param = "email=interpro-team@ebi.ac.uk&title=" + title + "&sequence=" + sequence + "&appl=TIGRFAM&appl=SFLD&appl=Panther&appl=HAMAP&appl=PrositeProfiles&appl=PrositePatterns&appl=SMART&appl=CDD&appl=PRINTS&appl=PfamA&appl=PIRSF&appl=SuperFamily&appl=Gene3d&appl=Phobius&appl=SignalP&appl=Coils&appl=MobiDBLite&appl=TMHMM&appl=SignalP_EUK&appl=SignalP_GRAM_POSITIVE&appl=SignalP_GRAM_NEGATIVE&goterms=true&pathways=true";

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);
            HttpEntity<String> request = new HttpEntity<>(param, headers);
            return new RestTemplate().postForObject("https://www.ebi.ac.uk/Tools/services/rest/iprscan5/run", request, String.class);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }


}
