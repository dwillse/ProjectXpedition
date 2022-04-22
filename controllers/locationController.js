const model = require('../models/location');
const model2 = require("../models/user");


exports.pref = (req, res) => {
    let id = req.session.user;
    Promise.all([model2.findById(id)])
    .then(results=> {
        const [user] = results;
        res.render('./location/choosePref', {user})
    })
    .catch(err=>next(err));
   
};



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
    res.render('./location/results');
    
};