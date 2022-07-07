let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfPost = obj[i];
    nymfPost.pro = false;
    nymfPost.censored = false;
    nymfPost.web_unlock = true;
    nymfPost.portrait = true;
}


$done({body: JSON.stringify(obj)});