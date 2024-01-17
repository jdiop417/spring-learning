let obj = JSON.parse($response.body);
if (!obj) {
    $done();
}

for (let prop in obj) {
    let segment = obj[prop];
    if (!segment.length) {
        continue;
    }

    for (let j in segment) {
        let element = segment[j];
        if (!element) {
            continue;
        }
        element.pro = false;
        element.censored = false;
    }
}

$done({body: JSON.stringify(obj)});