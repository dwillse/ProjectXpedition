window.onload = function hello() {
    let location = window.location.href;
    location = location.substring(location.indexOf("=") + 1, location.length);
    location = location.charAt(0).toUpperCase() + location.slice(1);
    let pHeader = document.getElementById("pHeader");
    
    if(window.location.href.includes("preferences")) {
        pHeader.innerHTML = location;
    }

    if(window.location.href.includes("ratings")) {
        let pref = window.location.href;
        pref = pref.substring(pref.indexOf("pref"), pref.length);
        let tags = pref.split("pref=", 10);
        tags.shift();

        for(var i = 0; i < tags.length; i++) {
            if(tags[i].includes("&") || tags[i].includes("+")) {
                tags[i] = tags[i].replace("&", "");
                tags[i] = tags[i].replace("+", " ");
            }
        }

        let pTags = document.getElementsByClassName("AttractionText");
        
        for(let i = 0; i < pTags.length; i++) {
            pTags[i].innerHTML = tags[i];
        }
        


    }
}


function selectedPref() {
    const btn = document.querySelector('#btn');
    btn.addEventListener('click', (event) => {
        let checkboxes = document.querySelectorAll('input[name="pref"]:checked');
        let values = [];
        checkboxes.forEach((checkbox) => {
            values.push(checkbox.value);
        });
    });
}

function enableButton() {
    var select = document.getElementById('location');
    var btn = document.getElementById('startBtn');
    btn.disabled = !select.value;
}
function updateText() {

}