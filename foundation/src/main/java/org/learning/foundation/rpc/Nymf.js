let obj = JSON.parse($response.body);
if (obj == null) {
    $done();
}

for (let nymfPhoto of obj) {
    if (!nymfPhoto.specifications.startsWith("Premium")) {
        continue;
    }
    nymfPhoto.specifications.replace("Premium", "Free");
    nymfPhoto.blurred = nymfPhoto.source;
}
$done({body: JSON.stringify(obj)});