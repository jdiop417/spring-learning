let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

if (!Array.isArray(obj)) {
    obj.pro = false;
    $done({body: JSON.stringify(obj)});
}

for (let i = 0; i < obj.length; i++) {
    let nymfStory = obj[i];
    nymfStory.pro = false;
    nymfStory.censored = false;
}

$done({body: JSON.stringify(obj)});
