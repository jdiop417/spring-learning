let obj = JSON.parse($response.body);
if (!obj) {
    $done();
}

for (let i in obj) {
    let comic = obj[i];
    if (!comic) {
        continue;
    }

    comic.pro = false;
    comic.censored = false;
}

$done({body: JSON.stringify(obj)});