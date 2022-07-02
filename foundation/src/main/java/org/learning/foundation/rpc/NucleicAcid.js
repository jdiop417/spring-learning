let obj = JSON.parse($response.body);
console.log(`response.body before modify:+ ${JSON.stringify(obj)}`);
if (obj.data == null || obj.data[0] == null) {
    console.log("response.body.data is null");
    obj.data = [{
        "hscysj": "2022-07-01 10:03:42.0",
        "hsjcsj": "2022-07-02 00:00:32.0",
        "hsjcjq": "阴性",
        "hsjcjgmc": "成都大哲医学检验实验室",
        "inDay7": true,
        "xm": "*洋",
        "zjhm": "51**************16",
        "hsjcjg": "阴性"
    }];
    console.log(`response.body after add element: ${JSON.stringify(obj)}`);
}

console.log(`data.length: ${obj.data.length}`);
let now = new Date();
let yesterday = new Date(now.getTime() - 86400000);
let year = yesterday.getFullYear();
let month = yesterday.getMonth() + 1;
let date = yesterday.getDate();
let hscysj_pre = year + "-" + pad(month) + "-" + pad(date);

for (let i = 0; i < obj.data.length; i++) {
    let hscj = obj.data[i];
    if (hscj.hscysj.startsWith(hscysj_pre)) {
        $done({body: JSON.stringify(obj)});
    }
}


let hour = date % 8 + 9;
let hscysj = hscysj_pre + " " + pad(hour) + ":00:32.0";
console.log(`hscysj:${hscysj}`);

let hsjcsj = year + "-" + pad(now.getMonth() + 1) + "-" + pad(now.getDate()) + " 00:00:32.0";
if (hour <= 9) {
    hsjcsj = year + "-" + pad(now.getMonth() + 1) + "-" + pad(yesterday.getDate()) + " 12:00:32.0";
}
console.log(`hsjcsj:${hsjcsj}`);

obj.data[0].hscysj = hscysj;
obj.data[0].hsjcsj = hsjcsj;
obj.data[0].inDay7 = true;

const mc = new Map([[0, "成都大哲医学检验实验室"]
    , [1, "成都市第二人民医院"]
    , [2, "四川天府新区人民医院"]
    , [3, "高新达安医学检验所"]
    , [4, "成都新基因格医学检验所"]
    , [5, "成飞医院"]
    , [6, "成都市疾病預防控制中心"]]);
obj.data[0].hsjcjgmc = mc.get(date % mc.size);
console.log(`hsjcjgmc:${obj.data[0].hsjcjgmc}`);

function pad(i) {
    return String(i).padStart(2, '0');
}

console.log(`response.body after modify:${JSON.stringify(obj)}`);
$done({body: JSON.stringify(obj)});