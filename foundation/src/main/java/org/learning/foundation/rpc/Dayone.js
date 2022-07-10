let bodyJson = JSON.parse($response.body);
console.log(`response.body before modify:${JSON.stringify(bodyJson)}`);
if (bodyJson == null || bodyJson.featureBundle == null) {
    console.log("response.body or response.featureBundle is null");
    $done();
}

let featureBundle = bodyJson.featureBundle;
featureBundle.bundleName = "premium";
featureBundle.featuresFull.forEach(f => {
    f.enabled = true;
    f.canUpgrade = false;
})
featureBundle.features = featureBundle.featuresFull;


bodyJson.isAdmin = true;
bodyJson.isEligibleForTrial = true;
bodyJson.subscription.premium = true;

console.log(`response.body after modify:${JSON.stringify(bodyJson)}`);
$done({body: JSON.stringify(bodyJson)});