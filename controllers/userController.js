const model = require("../models/user");

const sql = require('mysql');

const con = sql.createConnection( {
    host: "localhost",
    user: "root",
    password: "password",
    database: "XpedData"
});

con.connect(function(err) {
    if (err) throw err;
});

con.query("SELECT * FROM Users", function (err, rows) {
    if (err) throw err;
    console.log(rows);
    /*rows.forEach((row) => {
        console.log(`first name: ${row.FNAME}, last name: ${row.LNAME}`);
    });*/
});

exports.new = (req, res) => {
    res.render("./user/create");
};

exports.create = (req, res, next) => {
    let account = req.body;
    con.query('INSERT INTO Users SET ?', account, (err, res) => {
        if(err) throw err;
    });
    return res.redirect('/');
};

exports.getUserLogin = (req, res) => {
    res.render('./user/login');
};

exports.login = (req, res, next) => {

};

exports.logout = (req, res, next) => {

};