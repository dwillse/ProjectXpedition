const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");
const itineraryModel = require('../models/itinerary');
const prefs = new preferenceModel();

const java = require('java');
const { Console } = require('console');
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
// includes running java code
exports.itinerary = (req, res, next) => {
    let user = req.session.user;
    prefs.chosen = req.body;
    prefs.userName = req.session.user;
    prefs.save();

    let stringPref = Object.entries(prefs.chosen);
    console.log(stringPref.toString() + ',');
    stringPref = stringPref.toString() + ',';
    for (let i = 0; i < 5; i++) {
        stringPref = stringPref.replace(',1,', ' ').replace(',2,', ' ').replace(',3,', ' ').replace(',4,', ' ').replace(',5,', ' ');
    }
    stringPref = stringPref.trim();
    console.log(stringPref);
    console.log(user);
    console.log('java -jar public/java/xped/XpeditionGradleTest.jar' + ' ' + user + ' ' + stringPref);

    exec('java -jar public/java/xped/XpeditionGradleTest.jar' + ' ' + user + ' ' + stringPref, function callback(err, stdout, stderr) {
        console.log(stdout);
        console.log(stderr);
        console.log('-------------');
        console.log(err);
    });

    setTimeout(() => {
        Promise.all([userModel.findById(user), preferenceModel.find(), 
            itineraryModel.findOne({ userName: user }).populate('excursion1').populate('excursion2').populate('excursion3').populate('excursion4').populate('excursion5')])
        .then(results => {
            const [user, preference, itinerary] = results;
            res.render('./location/results', {user, preference, itinerary})
        })
        .catch(err=>next(err));
    }, 4000);

    setTimeout(() => {
        preferenceModel.deleteMany({ userName: user }, function (err) {
            if(err) console.log(err);
            console.log("Successful deletion");
        });
    }, 20000);
};

// redirects to details page and inserts info into page
exports.details = (req, res, next)=> {
    let id = req.params.id;
    let Excursion = model.findById(id)
    if(Excursion) {
        res.render('./location/details', {Excursion});
    } else {
    let err = new Error('Cannot find that location' + id);
        err.status = 404;
        next(err);
    }
};