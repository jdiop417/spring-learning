let obj = JSON.parse($response.body);

if (obj == null) {
    $done();
}

if (!Array.isArray(obj)) {
    obj.pro = false;

    let scenes = obj.scenes;
    if (Array.isArray(scenes)) {
        for (let j = 0; j < scenes.length; j++) {
            let scene = scenes[j];
            scene.pro = false;
        }
    }

    let files = obj.files;
    if (Array.isArray(files)) {
        for (let j = 0; j < files.length; j++) {
            let file = files[j];
            file.pro = false;
        }
    }

    $done({body: JSON.stringify(obj)});
}

for (let i = 0; i < obj.length; i++) {
    let nymfStory = obj[i];
    nymfStory.pro = false;
    nymfStory.censored = false;
}

$done({body: JSON.stringify(obj)});
