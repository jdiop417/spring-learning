var uri=$request.url;
let target = decodeURIComponent(uri.substring("https://link.zhihu.com/?target=".length));

const myResponse = {
    status: "302 Found",
    headers: {"Location": target}
};

$done(myResponse);