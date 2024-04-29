let obj = JSON.parse($response.body);
if (obj == null) {
    $done();
}

for (let photo of obj) {
    photo.pro = false;
    if (photo.specifications.includes('Premium')) {
        photo.specifications = photo.specifications.replace('Premium', 'Free');
    }
}

$done({body: JSON.stringify(obj)});