let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

for (let post of obj) {
    post.pro = false;
}


$done({body: JSON.stringify(obj)});