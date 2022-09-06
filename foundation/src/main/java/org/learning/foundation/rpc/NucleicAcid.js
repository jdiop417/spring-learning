let obj = JSON.parse($response.body);
console.log(`response.body before modify:+ ${JSON.stringify(obj)}`);
if (obj.data == null || obj.data[0] == null) {
    console.log("response.body.data is null");
    obj.data = [];
}

console.log(`data.length: ${obj.data.length}`);
obj.data = nucleicAcid(obj.data, yesterday());
obj.data = nucleicAcid(obj.data, theDayBefore(yesterday()));
obj.data = nucleicAcid(obj.data, theDayBefore(theDayBefore(yesterday())));

console.log(`response.body after modify:${JSON.stringify(obj)}`);
$done({body: JSON.stringify(obj)});


function nucleicAcid(data, date) {
    if (data == null || data[0] == null) {
        data = [];
    }

    for (let i = 0; i < data.length; i++) {
        let hscysj_date = dateFormat(data[i].hscysj);
        if (!isSameDay(hscysj_date, date)) {
            continue;
        }

        console.log(`${hscysj_date} already have acid`);
        data[i].inDay7 = true;
        data[i].hsjcjq = "阴性";

        if (isYesterday(hscysj_date) && !within24Hours(dateFormat(data[i].hsjcsj))) {
            console.log(`${hscysj_date} already have acid ,but not with in 24 hours`);
            data[i].hsjcsj = setHourAndToLocaleDateString(today(), 0);
            return data;
        }
        return data;
    }

    let t = {
        "hscysj": "2022-07-01 10:03:42.0",
        "hsjcsj": "2022-07-02 00:00:32.0",
        "hsjcjq": "阴性",
        "hsjcjgmc": "成都大哲医学检验实验室",
        "inDay7": true,
        "xm": "*洋",
        "zjhm": "51**************16",
        "hsjcjg": "阴性"
    };

    let hscysj_hour = (date.getDate() * 3 + date.getDate() % 3) % 9 + 9;
    t.hscysj = setHourAndToLocaleDateString(date, hscysj_hour);

    let hsjcsj_hour = hscysj_hour + hscysj_hour % 3;
    if (hsjcsj_hour >= 9 && hsjcsj_hour <= 12) {
        hsjcsj_hour += 4;
    } else if (hsjcsj_hour > 12 && hsjcsj_hour < 16) {
        hsjcsj_hour += 6;
    } else if (hsjcsj_hour >= 16) {
        hsjcsj_hour += 8;
    }
    t.hsjcsj = setHourAndToLocaleDateString(date, hsjcsj_hour);
    if (isYesterday(dateFormat(t.hscysj)) && !within24Hours(dateFormat(t.hsjcsj))) {
        console.log(`${t.hscysj} already have acid ,but not with in 24 hours`);
        t.hsjcsj = setHourAndToLocaleDateString(today(), 0);
    }

    const mc = new Map([[0, "成都大哲医学检验实验室"], [1, "成都市第二人民医院"], [2, "四川天府新区人民医院"], [3, "高新达安医学检验所"], [4, "成都新基因格医学检验所"], [5, "成飞医院"], [6, "成都市疾病預防控制中心"], [7, "成都高新华曦医学检验实验室"]]);
    t.hsjcjgmc = mc.get(hscysj_hour % mc.size);

    data.unshift(t);
    return data;
}


function isSameDay(date1, date2) {
    return toLocaleString(date2).startsWith(toLocaleDateString(date1));
}

function isYesterday(date) {
    return isSameDay(date, yesterday());
}

function today() {
    return new Date();
}


function within24Hours(date) {
    return (new Date().getTime() - date.getTime()) < 86400000;
}


function theDayBefore(date) {
    return new Date(date.getTime() - 86400000);
}

function yesterday() {
    return theDayBefore(new Date());
}

function nextDay(date) {
    return new Date(date.getTime() + 86400000);
}

function dateFormat(date) {
    let year = date.substring(0, 4);
    let month = date.substring(5, 7) - 1;
    let day = date.substring(8, 10);
    let hour = date.substring(11, 13);
    let minute = date.substring(14, 16);
    let second = date.substring(17, 19);
    let ms = date.substring(20, 21);
    return new Date(year, month, day, hour, minute, second, ms);
}


function toLocaleString(date) {
    let hour = date.getHours();
    let minute = date.getMinutes();
    let second = date.getSeconds();
    let ms = date.getMilliseconds();
    return toLocaleDateString(date) + " " + pad(hour) + ":" + pad(minute) + ":" + pad(second) + "." + ms;
}

function toLocaleDateString(date) {
    let year = date.getFullYear();
    let month = date.getMonth() + 1;
    let day = date.getDate();
    return year + "-" + pad(month) + "-" + pad(day);
}

function setHourAndToLocaleDateString(date, hour) {
    let date1 = new Date(date.getTime());
    if (hour < 24) {
        date1.setHours(hour);
    } else {
        date1 = nextDay(date);
        date1.setHours(hour - 24);
    }
    return toLocaleString(date1);
}


function pad(i) {
    return String(i).padStart(2, '0');
}