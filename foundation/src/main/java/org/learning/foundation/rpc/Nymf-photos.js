let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfPhoto = obj[i];
    nymfPhoto.pro = false;
    nymfPhoto.censored=false;
    nymfPhoto.active = true;
    nymfPhoto.main = nymfPhoto.pro_main;
    nymfPhoto.miniature = nymfPhoto.pro_miniature;
    nymfPhoto.watermark = nymfPhoto.pro_main;
    nymfPhoto.blurred = nymfPhoto.source;
}

$done({body: JSON.stringify(obj)});