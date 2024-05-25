var uri = $request.url;
uri = decodeURIComponent(uri);
let target = uri.substring(uri.indexOf("url=") + 4)

var modifiedStatus = 'HTTP/1.1 302 Found';
var myHeaders = {"Location": target};

var myResponse = {status: modifiedStatus, headers: myHeaders};
console.log(JSON.stringify(myResponse));
$done(myResponse);