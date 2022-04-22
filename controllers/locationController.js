const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");


exports.pref = (req, res) => {
    let id = req.session.user;
    console.log(req.query);
    console.log(req.body);
    let country = new preferenceModel();
    country.country = req.body;
    country.save();
    Promise.all([userModel.findById(id)])
    .then(results => {
        const [user] = results;
        res.render('./location/choosePref', {user})
    })
    .catch(err=>next(err));
};

exports.country = (req, res, next) => {
    console.log(req.body.location);
    res.render('./location/choosePref');
}

exports.ratings = (req, res) => {
    res.render('./location/ratePref');
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

exports.results = (req, res) => {   
    console.log(req.query);
    console.log(req.body);
    let prefs = new preferenceModel();
    prefs.chosen = req.body;
    prefs.save();
    res.render('./location/results');
};