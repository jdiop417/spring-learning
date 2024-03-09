let obj = JSON.parse($response.body);
if (!obj) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let resource = obj[i];
    if ((!resource) || (!resource.result)) {
        continue;
    }

    for (let j = 0; j < resource.result.length; j++) {
        result[j].pro = false;
    }
}
$done({body: JSON.stringify(obj)});