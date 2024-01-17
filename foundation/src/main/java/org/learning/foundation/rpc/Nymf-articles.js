let obj = JSON.parse($response.body);
if (!obj) {
    $done();
}

for (let prop in obj) {
    let article = obj[prop];
    if (!article) {
        continue;
    }

    article.pro = false;
    article.censored = false;
}

$done({body: JSON.stringify(obj)});