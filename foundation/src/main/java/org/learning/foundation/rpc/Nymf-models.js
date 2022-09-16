let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfModel = obj[i];
    fullDescAddUrl(nymfModel, nymfModel.instagram_url);
    fullDescAddUrl(nymfModel, nymfModel.patreon_url);
    fullDescAddUrl(nymfModel, nymfModel.onlyfans_url);
    fullDescAddUrl(nymfModel, nymfModel.facebook_url);
    fullDescAddUrl(nymfModel, nymfModel.other_url);
}

function fullDescAddUrl(nymfModel, url) {
    if (url != null) {
        nymfModel.full_description += "\n" + url;
    }
}

$done({body: JSON.stringify(obj)});