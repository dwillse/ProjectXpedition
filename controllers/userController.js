const model = require("../models/user");


exports.results = (req, res)=> {
    let locations = model.find();
    res.render('./location/results', {locations});
};

exports.login = (req, res) => {
    res.render('./user/login');
};

exports.new = (req, res) => {
    res.render("./user/create");
};

exports.pref = (req, res) => {
    res.render('../location/choosePref');
};
    
exports.ratings = (req, res) => {
    res.render('./location/choosePref');
};

exports.home = (req, res) => {
    res.render('./index');
};



exports.details = (req, res, next)=> {
    let id = req.params.id;
    let location = model.findById(id);
    if(drink) {
        res.render('./location/details', {location});
    } else {
    let err = new Error('Cannot find that location' + id);
        err.status = 404;
        next(err);
    }
};

exports.rating = (req, res) => {
    res.render('./location/ratePref');
};