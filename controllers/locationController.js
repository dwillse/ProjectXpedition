const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");
const prefs = new preferenceModel();

const java = require('java');
const exec = require('child_process').exec;


// post for selecting country and redirecting to choosePref
exports.country = (req, res) => {
    let user = req.session.user;
    prefs.country = req.body.location;
    Promise.all([userModel.findById(user)])
    .then(results => {
        const [user] = results;
        res.render('./location/choosePref', {user})
    })
    .catch(err=>next(err));
};

// get for redirecting to choosePref
exports.pref = (req, res, next) => {
    res.render('./location/choosePref');
}

// get for redirecting to ratePref
exports.ratings = (req, res) => {
    res.render('./location/ratePref');
};

// get for redirecting to results
exports.results = (req, res) => {
    res.render('./location/results');
}

// post for chosen and rated preferences and redirecting to results page
exports.itinerary = (req, res, next) => {   
    prefs.chosen = req.body;
    prefs.userName = req.session.user;
    prefs.save();
    console.log(prefs);
    console.log('----------');
    console.log(typeof(prefs.chosen));
    let stringPref = Object.entries(prefs.chosen);
    
    let firstPref = stringPref[0].toString().replace(',', ' ');
    let secondPref = stringPref[1].toString().replace(',', ' ');
    let thirdPref = stringPref[2].toString().replace(',', ' ');

    let javaInput = prefs.country + ' ' + firstPref + ' ' + secondPref + ' ' + thirdPref; //ex string: belize Club 4 Ocean 3 Art 2 Beaches 5
                                                                                        //java args[]: args[0] args[1].... java uses a space as a delimeter
    exec('java public/java/Test.java ' + javaInput, function callback(err, stdout, stderr) { //javaInput are the args being passed to the file
        console.log(stdout);
    });
    res.render('./location/results');
};

// redirects to details page and inserts info into page
exports.details = (req, res, next)=> {
    let id = req.params.id;
    let location = model.findById(id);
    if(location) {
        res.render('./location/details', {location});
    } else {
    let err = new Error('Cannot find that location' + id);
        err.status = 404;
        next(err);
    }
};