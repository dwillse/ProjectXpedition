

window.onload = function hello() {
    let location = "Belize";
    localStorage.setItem("location", location);
    
    
    if(window.location.href.includes("preferences")) {
        pHeader.innerHTML = location;
    }

    if(window.location.href.includes("ratings")) {
        let pref = window.location.href;
        pref = pref.substring(pref.indexOf("prefs"), pref.length);
        let tags = pref.split("prefs=", 11);
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
            let imageURL = "";
            switch(tags[i]) {
                case 'club': imageURL = '../images/club.jpg'; break;
                case 'ocean': imageURL = '../images/ocean.jpg'; break;
                case 'bar': imageURL = '../images/bar.jpeg'; break;
                case 'restaurant': imageURL = '../images/rest.jpg'; break;
                case 'tour': imageURL = '../images/tour.jpg'; break;
                case 'spa': imageURL = '../images/spa.jpg'; break;
                case 'beach': imageURL = '../images/beach.jpg'; break;
                case 'museum': imageURL = '../images/museum.jpg'; break;
                case 'park': imageURL = '../images/park.jpg'; break;
                case 'art': imageURL ='../images/art.jpg'; break;
                default: break;
            }
            let pictures = document.getElementsByTagName("img");
            pictures[i + 1].src = imageURL; // offset by 1 because first image is webpage logo
        }
        

        //figure out how many are showing
        //get the class stars and then loop through all the inputs and change the rating attr to tag value
        let radioBtn = document.querySelectorAll('input[type=radio]');
        radioBtn = Array.from(radioBtn);

        for(let i = 0; i < tags.length; i++) {
            for(let x = 0; x < 5; x++) {
                radioBtn[x].name = pTags[i].innerHTML;
            }    
            
            for(let x = 0; x < 5; x++) { radioBtn.shift(); }
        }


        let slots = document.getElementsByClassName("columnRate");
        
        for(let x = tags.length; x < 10; x++) {
            slots[x].style.display = "none";
        }
        
        document.querySelectorAll('input[type=checkbox]')[0].name = localStorage.getItem('location');
    }

}

function check() {
    let checkboxes = document.querySelectorAll('input[name="prefs"]:checked');

    if(checkboxes.length != 0) {
        document.getElementById("btn").disabled = false;
    } else {
        document.getElementById("btn").disabled = true;
    }
}

function rateCheck() {
    let radioBtn = document.querySelectorAll('input[type=radio]');

    if(radioBtn.length != 0) {
        document.getElementById("button").disabled = false;
    } else {
        document.getElementById("button").disabled = true;
    }
}

function selectedPref() {
    const btn = document.querySelector('#btn');
    btn.addEventListener('click', (event) => {
        let checkboxes = document.querySelectorAll('input[name="prefs"]:checked');
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

function download(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
  
    element.style.display = 'none';
    document.body.appendChild(element);
  
    element.click();
  
    document.body.removeChild(element);
}
  
