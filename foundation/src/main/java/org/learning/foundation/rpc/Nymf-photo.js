let obj = JSON.parse($response.body);
console.log(`response.body before modify:+ ${JSON.stringify(obj)}`);
if (obj == null) {
    $done();
}

obj.pro = false;
console.log(`response.body after modify:+ ${JSON.stringify(obj)}`);
$done({body: JSON.stringify(obj)});