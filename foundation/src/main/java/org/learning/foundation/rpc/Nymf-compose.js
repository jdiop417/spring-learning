let obj = JSON.parse($response.body);
console.log(`"obj before modify:${JSON.stringify(obj)}`)
if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let compose = obj[i];
    let result = compose.result;
    if (!result) {
        continue;
    }
    if (!Array.isArray(result)) {
        result.pro = false;
        result.censored = false;
        continue;
    }

    for (let j = 0; j < result.length; j++) {
        let nymfPost = result[j];
        if (!result) {
            continue;
        }
        nymfPost.pro = false;
        nymfPost.censored = false;
    }
}

console.log(`"obj after modify:${JSON.stringify(obj)}`)
$done({body: JSON.stringify(obj)});