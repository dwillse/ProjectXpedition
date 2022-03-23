const model = require('../models/location');

/*exports.index = (req, res) => {
    let locations = model.find();
    res.render('./location/index', {locations});
};*/

exports.choosePref = (req, res) => {
    res.render('./location/choosePref');
};

/*exports.choose = (req, res, next) => {

};*/

exports.ratePref = (req, res) => {
    res.render('./location/ratePref');
};

/*exports.ratings = (req, res, next) => {

};*/