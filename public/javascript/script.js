locations = [
    {
        id: 1,
        country: 'Belize',
        content: 'asdfklajsdlfkajs',
        
    }
];

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
        let tags = pref.split("pref=", 11);
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
                case 'Ruins': imageURL = '../images/ruins.jpg'; break;
                case 'Ocean': imageURL = '../images/ocean.jpg'; break;
                case 'Snorkel': imageURL = '../images/snorkel.jpg'; break;
                case 'Caves': imageURL = '../images/caves.jpg'; break;
                case 'Fine Dining': imageURL = '../images/fine.jpg'; break;
                case 'Local Food': imageURL = '../images/local.jpg'; break;
                case 'Beaches': imageURL = '../images/beach.jpg'; break;
                case 'Museums': imageURL = '../images/museum.jpg'; break;
                case 'Jungles': imageURL = '../images/jungle.jpg'; break;
                case 'Bird Watching': imageURL ='../images/bird.jpg'; break;
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
        
        
    }

    if(window.location.href.includes("results")) {
        let results = window.location.href;
        results = results.substring(results.indexOf("results") + 8, results.length);
        results = results.split("&", 11);
        
        


    }
}

function check() {
    let checkboxes = document.querySelectorAll('input[name="pref"]:checked');

    if(checkboxes.length != 0) {
        document.getElementById("btn").disabled = false;
    } else {
        document.getElementById("btn").disabled = true;
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

/* 
window.onload = function updateText() {
let slotNum = document.getElementsByClassName("AttractionText");
if(ruins.value =="Ruins" && document.getElementById("ruins").ariaChecked == true){
    slotNum[0].innerHTML = "test";
}

}*/
