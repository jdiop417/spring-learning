var uri = $request.url;
let target = decodeURIComponent(uri.substring("https://link.zhihu.com/?target=".length));

var modifiedStatus = 'HTTP/1.1 302 Found';
var myHeaders = {"Location": target};

var myResponse = {status: modifiedStatus, headers: myHeaders};
console.log(JSON.stringify(myResponse));
$done(myResponse);