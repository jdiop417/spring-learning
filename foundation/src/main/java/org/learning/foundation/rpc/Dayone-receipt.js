let bodyJson = JSON.parse($response.body);
console.log(`response.body before modify:${JSON.stringify(bodyJson)}`);
if (bodyJson == null || bodyJson.bundle == null || bodyJson.bundle.featuresFull == null) {
    console.log("response.featureBundle is null");
    $done();
}

let bundle = bodyJson.bundle;
bundle.featuresFull.forEach(f => {
    if (f.hasOwnProperty("enabled")) {
        f.enabled = true;
    }
    f.canUpgrade = false;
})
bundle.features = bundle.featuresFull;

console.log(`response.body after modify:${JSON.stringify(bodyJson)}`);
$done({body: JSON.stringify(bodyJson)});