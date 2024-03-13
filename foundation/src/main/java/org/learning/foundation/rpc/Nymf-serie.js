let obj = JSON.parse($response.body);
if (!obj) {
    $done();
}

let photos = obj.photos;
if (!photos) {
    $done();
}

for (let photo of photos) {
    photo.pro = false;
}

$done({body: JSON.stringify(obj)});