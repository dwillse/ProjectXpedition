const model = require('../models/location');
const java = require('java');
const exec = require('child_process').exec;

exports.pref = (req, res) => {
    res.render('./location/choosePref');
};

/*exports.choose = (req, res, next) => {

};*/

exports.ratings = (req, res) => {
    res.render('./location/ratePref');
};

/*exports.ratings = (req, res, next) => {

};*/

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
    /*let locations = model.find();
    res.render('./location/results', {locations});
    */
   
    console.log(req.query);
    
    //this is where the alogrithm needs to be implemented 
    //have to return the results here

    exec('java public/java/Test.java', function callback(err, stdout, stderr) {
        console.log(stdout);
    });

    res.render('./location/results');
    
};