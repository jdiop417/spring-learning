let bodyJson = JSON.parse($response.body);
console.log(`response.body before modify:${JSON.stringify(bodyJson)}`);
if (bodyJson == null || bodyJson.featureBundle == null) {
    console.log("response.featureBundle is null");
    $done();
}

let featureBundle = bodyJson.featureBundle;
featureBundle.featuresFull.forEach(f => {
    if (f.hasOwnProperty("enabled")) {
        f.enabled = true;
    }
    f.canUpgrade = false;
})
featureBundle.features = featureBundle.featuresFull;


console.log(`response.body after modify:${JSON.stringify(bodyJson)}`);
$done({body: JSON.stringify(bodyJson)});