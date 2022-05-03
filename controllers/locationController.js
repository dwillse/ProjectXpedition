const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");
const itineraryModel = require('../models/itinerary');
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
    let user = req.session.user;
    prefs.chosen = req.body;
    prefs.userName = req.session.user;
    prefs.save();
    exec('java public/java/Test.java', function callback(err, stdout, stderr) {
        console.log(stdout);
    });
    Promise.all([userModel.findById(user), preferenceModel.find(), itineraryModel.findOne().populate('excursion1', 'EXCURSION')])
    .then(results => {
        const [user, preference, itinerary] = results;
        res.render('./location/results', {user, preference, itinerary})
    })
    .catch(err=>next(err));
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