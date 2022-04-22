const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");


exports.country = (req, res) => {
    let user = req.session.user;
    //let id = req.param.id;
    let country = new preferenceModel();
    country.country = req.body.location;
    //const chosenCountry = country.country;
    country.save();
    Promise.all([userModel.findById(user)])
    .then(results => {
        const [user] = results;
        res.render('./location/choosePref', {user})
    })
    .catch(err=>next(err));
};

exports.pref = (req, res, next) => {
    console.log(req.body.location);
    res.render('./location/choosePref');
}

exports.ratings = (req, res) => {
    res.render('./location/ratePref');
};

exports.results = (req, res) => {
    res.render('./location/results');
}

exports.itinerary = (req, res, next) => {   
    let id = req.param.id;
    let location = model.findById(id);
    if(location) {
        let prefs = new preferenceModel();
        prefs.chosen = req.body;
        prefs.save();
        res.render('./location/results');
    } else {
        let err = new Error('Cannot find that location' + id);
        err.status = 404;
        next(err);
    }
};

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