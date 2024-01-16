var body = $response.body;
console.log(`"obj before modify:${JSON.stringify(obj)}`)
let obj = JSON.parse(body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfSeries = obj[i];
    let photos = nymfSeries.photos;

    if (!photos.length) {
        continue;
    }

    for (let i in photos) {
        let photo = photos[i];
        if (!photo) {
            continue;
        }
        photo.pro = false;
        photo.censored = false;
    }
}

$done({body: JSON.stringify(obj)});