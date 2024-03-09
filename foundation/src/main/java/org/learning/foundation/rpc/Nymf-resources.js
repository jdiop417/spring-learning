let obj = JSON.parse($response.body);
if (!obj) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let resource = obj[i];
    if (!resource) {
        continue;
    }

    resource.pro = false;
}
$done({body: JSON.stringify(obj)});