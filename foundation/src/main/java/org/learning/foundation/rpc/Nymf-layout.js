let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfVideo = obj[i];
    let result = nymfVideo.result;
    if (!Array.isArray(result)) {
        result.pro = false;
    }
    else {
        for (let j = 0; j < result.length; j++) {
            let nymfPost = result[j];
            nymfPost.pro = false;
        }
    }
}


$done({body: JSON.stringify(obj)});