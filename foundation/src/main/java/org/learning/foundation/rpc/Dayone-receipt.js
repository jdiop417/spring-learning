let bodyJson = JSON.parse($response.body);
console.log(`response.body before modify:${JSON.stringify(bodyJson)}`);
if (bodyJson == null || bodyJson.featureBundle == null) {
    console.log("response.body or response.featureBundle is null");
    $done();
}

let bundle = bodyJson.bundle;
bundle.bundleName = "premium";
bundle.featuresFull.forEach(f => {
    if (f.hasOwnProperty("enabled")) {
        f.enabled = true;
    }

    f.canUpgrade = false;
})
bundle.features = bundle.featuresFull;


console.log(`response.body after modify:${JSON.stringify(bodyJson)}`);
$done({body: JSON.stringify(bodyJson)});