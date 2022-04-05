const model = require("../models/user");
const db = require("../db");

/*const sql = require('mysql');

const con = sql.createConnection( {
    host: "localhost",
    user: "root",
    password: "password",
    database: "XpedData"
});*/

/*con.connect(function(err) {
    if (err) throw err;
    console.log('Database Connected');
});*/

db.query("SELECT * FROM Users", function (err, rows) {
    if (err) throw err;
    console.log(rows);
});

exports.new = (req, res) => {
    res.render("./user/create");
};

// Need to hash passwords
// Need to store emails all lowercase
// catch errors: validation error and email has already been used
exports.create = (req, res, next) => {
    let account = req.body;
    db.query('INSERT INTO Users SET ?', account, (err, res) => {
        if(err) throw err;
    });
    return res.redirect('/');
};

exports.getUserLogin = (req, res) => {
    res.render('./user/login');
};

// Does not currently work if you put in the incorrect email address
// Need to make emails all lowercase
// catch errors: incorrect email and incorrect password
exports.login = (req, res, next) => {
    let account = req.body;
    db.query("SELECT * FROM Users", account, function (err, rows) {
        rows.forEach((row) => {
            if (req.body.EMAIL == `${row.EMAIL}`) {
                if (req.body.PASS != `${row.PASS}`) {
                    console.log('Incorrect Password');
                    res.redirect('./login');
                } else {
                    res.redirect('/');
                }
            }
        });
    });
    if (err) throw err;
};

exports.logout = (req, res, next) => {

};