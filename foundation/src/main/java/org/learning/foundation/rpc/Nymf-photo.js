let obj = JSON.parse($response.body);
if (obj == null) {
    $done();
}

obj.pro = false;
$done({body: JSON.stringify(obj)});