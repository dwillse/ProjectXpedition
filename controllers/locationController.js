const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");


// does not work
exports.country = (req, res, next) => {
    console.log('hi');
    let location = new preferenceModel(req.body);
    location.userName = req.session.user;
    location.save()
    .then(location => res.redirect('/locations/pref'))
    .catch(err => {
        if (err.name === 'ValidationError') {
            err.status = 400;
        }
        next(err);
    });
    console.log(req.body);
};

exports.pref = (req, res) => {
    let id = req.session.user;
    console.log(req.query);
    let country = new preferenceModel();
    country.country = req.query;
    country.save();
    Promise.all([userModel.findById(id)])
    .then(results => {
        const [user] = results;
        res.render('./location/choosePref', {user})
    })
    .catch(err=>next(err));
};

// does not work
exports.select = (req, res, next) => {
    console.log('select');
};

exports.ratings = (req, res) => {
    res.render('./location/ratePref');
};

// does not work
exports.rate = (req, res, next) => {
    console.log('ratings');
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
    let prefs = new preferenceModel();
    prefs.chosen = req.query;
    prefs.save();
    res.render('./location/results');
};