var obj = JSON.parse($response.body);
var now = new Date();
var yesterday = new Date(now - 24 * 3600 * 1000);
var year = yesterday.getFullYear();
var month = yesterday.getMonth() + 1;
var date = yesterday.getDate();
var hour = date % 6 + 9;
var minutes = yesterday.getMinutes();
var seconds = yesterday.getSeconds();
var hscysj = year + "-" + pad(month) + "-" + pad(date) + " " + pad(hour) + ":" + pad(minutes) + ":" + pad(seconds) + ".0";
var hsjcsj = year + "-" + pad(now.getMonth() + 1) + "-" + pad(now.getDate()) + " 00:00:32.0";

obj.data[0].hscysj = hscysj;
obj.data[0].hsjcsj = hsjcsj;

function pad(i) {
    return String(i).padStart(2, '0');
}

$done({body: JSON.stringify(obj)});