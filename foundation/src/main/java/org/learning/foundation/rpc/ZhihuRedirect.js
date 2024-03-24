let target = decodeURIComponent($request.url.substring("https://link.zhihu.com/?target=".length));

const myStatus = "HTTP/1.1 307 Temporary Redirect";
const myHeaders = {"Location": target};

const myResponse = {
    status: "HTTP/1.1 307 Temporary Redirect",
    headers: {"Location": target}
};

$done(myResponse);