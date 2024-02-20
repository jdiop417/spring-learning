let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let i = 0; i < obj.length; i++) {
    let nymfPhoto = obj[i];
    nymfPhoto.pro = false;
    nymfPhoto.censored=false;
}

$done({body: JSON.stringify(obj)});