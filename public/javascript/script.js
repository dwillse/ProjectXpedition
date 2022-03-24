window.onload = function hello() {
    let location = window.location.href;
    location = location.substring(location.indexOf("=") + 1, location.length);

    location = location.charAt(0).toUpperCase() + location.slice(1);
    
    let pHeader = document.getElementById("pHeader");

    pHeader.innerHTML = location;
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

window.onload = function updateText() {
let slotNum = document.getElementsByClassName("AttractionText");
if(ruins.value =="Ruins" && document.getElementById("ruins").ariaChecked == true){
    slotNum[0].innerHTML = "test";
}

}
