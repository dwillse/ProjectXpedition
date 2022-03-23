const model = require("../models/user");

exports.new = (req, res) => {
    res.render("./user/create");
};

exports.create = (req, res, next) => {

};

exports.getUserLogin = (req, res) => {
    res.render('./user/login');
};

exports.login = (req, res, next) => {

};

exports.logout = (req, res, next) => {

};