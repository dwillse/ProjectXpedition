

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

    /*if(window.location.href.includes("results")) {
        let results = window.location.href;
        results = results.substring(results.indexOf("results") + 8, results.length);
        results = results.split("&", 11); //holds (Tag=Rating)
        
        //document.getElementById("resultsHeader").innerHTML += localStorage.getItem("location"); //sets country name in header


        //start loop
        
        let fakeExcursion = ['Mayan Ruins', 'This excursion you get to visit the acient mayan ruins. You will be lead by a tour guide. You can se the ancient architecture created by the natives here from thousands of years ago.', 'Tour', 17.5567, -88.3271];
        
        let itinerary = document.getElementsByClassName('listExc');
        
        let imageURL = "";
        switch(fakeExcursion[2]) {
            case 'Club': imageURL = '../images/club.jpg'; break;
            case 'Ocean': imageURL = '../images/ocean.jpg'; break;
            case 'Bar': imageURL = '../images/bar.jpeg'; break;
            case 'Restaurant': imageURL = '../images/rest.jpg'; break;
            case 'Tour': imageURL = '../images/tour.jpg'; break;
            case 'Spa': imageURL = '../images/spa.jpg'; break;
            case 'Beaches': imageURL = '../images/beach.jpg'; break;
            case 'Museums': imageURL = '../images/museum.jpg'; break;
            case 'Park': imageURL = '../images/park.jpg'; break;
            case 'Art': imageURL ='../images/art.jpg'; break;
            default: break;
        }

        itinerary[0].getElementsByTagName('img')[0].src = imageURL;
        itinerary[0].getElementsByTagName('b')[0].innerHTML = fakeExcursion[0];
        itinerary[0].getElementsByTagName('p')[0].innerHTML = fakeExcursion[1];
        
        //end loop

        let loc = localStorage.getItem('location');

        //Belize 17.1899 N 88.4976 W
        //Brazil 14.2350 S 51.9253 W
        //England 52.355 N 1.1743 W
        //Italy 41.8719 N 12.5675 E
        //Japan 36.2048 N 138.2529 E
        //Country Latitude Longitude N(+) S(-) E(+) W(-)

        let startLat = 0;
        let startLon = 0;
        let zoomNum = 5;

        switch(loc) {
            case 'Belize': startLat = 17.1899; startLon = -88.4976; zoomNum = 7; break;
            case 'Brazil': startLat = -14.2350; startLon = -51.9253; break;
            case 'Japan': startLat = 36.2048; startLon = 138.2529; break;
            case 'Italy': startLat = 41.8719; startLon = 12.5675; break;
            case 'England': startLat = 52.355; startLon = -1.1743; break;
            default: break;
        }

        

        var attribution = new ol.control.Attribution({
            collapsible: false
        });

        var map = new ol.Map({
            controls: ol.control.defaults({attribution: false}).extend([attribution]),
            layers: [
                new ol.layer.Tile({
                    source: new ol.source.OSM()
                })
            ],
            target: 'map',
            view: new ol.View({
                center: ol.proj.fromLonLat([startLon, startLat]),
                maxZoom: 18,
                zoom: zoomNum
            })
        });


        //this adds a marker for the excursion
        var layer = new ol.layer.Vector({
            source: new ol.source.Vector({
                features: [
                    new ol.Feature({
                        geometry: new ol.geom.Point(ol.proj.fromLonLat([fakeExcursion[4], fakeExcursion[3]]))
                    })
                ]
            })
        });
        
        map.addLayer(layer);

        var container = document.getElementById('popup');
        var content = document.getElementById('popup-content');
        var closer = document.getElementById('popup-closer');
       
        var overlay = new ol.Overlay({
            element: container,
            autoPan: true,
            autoPanAnimation: {
                duration: 250
            }
        });
        map.addOverlay(overlay);

        content.innerHTML = '<b>' + fakeExcursion[0] + '</b>';
        overlay.setPosition(ol.proj.fromLonLat([fakeExcursion[4], fakeExcursion[3]]));

    } //end of results page if statement

*/

}

function check() {
    let checkboxes = document.querySelectorAll('input[name="prefs"]:checked');

    if(checkboxes.length != 0) {
        document.getElementById("btn").disabled = false;
    } else {
        document.getElementById("btn").disabled = true;
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

/* 
window.onload = function updateText() {
let slotNum = document.getElementsByClassName("AttractionText");
if(ruins.value =="Ruins" && document.getElementById("ruins").ariaChecked == true){
    slotNum[0].innerHTML = "test";
}

}*/

function download(filename, text) {
    var element = document.createElement('a');
    element.setAttribute('href', 'data:text/plain;charset=utf-8,' + encodeURIComponent(text));
    element.setAttribute('download', filename);
  
    element.style.display = 'none';
    document.body.appendChild(element);
  
    element.click();
  
    document.body.removeChild(element);
}
  
