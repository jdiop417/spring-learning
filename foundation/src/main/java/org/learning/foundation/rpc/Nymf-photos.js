let obj = JSON.parse($response.body);
if (obj == null) {
    $done();
}

for (let photo of obj) {
    photo.pro = false;
}

$done({body: JSON.stringify(obj)});