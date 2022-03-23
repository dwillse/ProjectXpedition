const { load } = require("nodemon/lib/config");

window.onload = function hello() {
    let location = window.location.href;
    location = location.substring(location.indexOf("=") + 1, location.length);

    location = location.charAt(0).toUpperCase() + location.slice(1);
    
    let pHeader = document.getElementById("pHeader");
<<<<<<< HEAD
    pHeader.innerHTML = location + "'s Preferences";
}

=======
    pHeader.innerHTML = location;
}
>>>>>>> 0b2913f3110586bbe4fddd91fae1a7e48f125c3c
