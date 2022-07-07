let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfModel = obj[i];
    if (nymfModel.instagram_url!=null) {
        nymfModel.description += "\n" + nymfModel.instagram_url;
    }
    if (nymfModel.onlyfans_url!=null) {
        nymfModel.description += "\n" + nymfModel.onlyfans_url;
    }
}


$done({body: JSON.stringify(obj)});