const model = require('../models/location');
const userModel = require("../models/user");
const preferenceModel = require("../models/preference");
const prefs = new preferenceModel();


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
    prefs.save();
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