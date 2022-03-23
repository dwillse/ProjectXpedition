window.onload = function hello() {
    let location = window.location.href;
    location = location.substring(location.indexOf("=") + 1, location.length);

    location = location.charAt(0).toUpperCase() + location.slice(1);
    
    let pHeader = document.getElementById("pHeader");
    pHeader.innerHTML = location;
}