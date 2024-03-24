let url = $request.url;
let url="https://link.zhihu.com/?target=https%3A//apps.apple.com/cn/app/anchor-pointer-%25E6%25AD%25A5%25E8%25A1%258C%25E8%25B7%25AF%25E7%25BA%25BF/id791684332%3Fuo%3D4";
let target = decodeURIComponent(url.substring("https://link.zhihu.com/?target=".length));

const myStatus = "HTTP/1.1 307 Temporary Redirect";
const myHeaders = {"Location": target};

const myResponse = {
    status: "HTTP/1.1 307 Temporary Redirect",
    headers: {"Location": target}
};

$done(myResponse);