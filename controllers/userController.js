/*const model = require("../models/user");


exports.results = (req, res)=> {
    let locations = model.find();
    res.render('./locations/results', {locations});
};

exports.login = (req, res) => {
    res.render('./user/login');
};

exports.new = (req, res) => {
    res.render("./user/create");
};

exports.pref = (req, res) => {
<<<<<<< HEAD
    res.render('../location/ratePref');
};*/
=======
    res.render('./location/ratePref');
};

exports.home = (req, res) => {
    res.render('./index');
};
>>>>>>> 640e4580a2d1aab19b62a95a20f1f993ff699d02


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
    res.render('./location/choosePref');
};