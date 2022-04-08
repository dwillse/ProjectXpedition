const model = require("../models/user");
const db = require("../db");
const bcrypt = require('bcrypt');
const { v4: uuidv4 } = require('uuid');


/*db.query("SELECT * FROM Users", function (err, rows) {
    if (err) throw err;
    console.log(rows);
});*/

exports.new = (req, res) => {
    res.render("./user/create");
};

// catch errors: validation error and email has already been used
exports.create = async (req, res, next) => {
    let account = req.body;
    if (account.EMAIL) {
        account.EMAIL = account.EMAIL.toLowerCase();
    }
    await bcrypt.hash(account.PASS, 10)
    .then(function(hash) {
        account.PASS = hash;
    });
    db.query('INSERT INTO Users SET ?', account, (err, res) => {
        if(err) throw err;
    });
    let userID = uuidv4();
    console.log(userID);
    db.query('UPDATE Users SET USERID = ? Where EMAIL = ?', [userID, account.EMAIL], (err, res) => {
        if (err) throw err;
    });
    return res.redirect('/');
};

exports.getUserLogin = (req, res) => {
    res.render('./user/login');
};

// Does not currently work if you put in the incorrect email address
// - possibly surround if statements in if statement for if email doesnt match existing emails it reloads page
// catch errors: incorrect email and incorrect password
exports.login = async (req, res, next) => {
    let account = req.body;
    if (account.EMAIL) {
        account.EMAIL = account.EMAIL.toLowerCase();
    }
    db.query("SELECT * FROM Users", account, async function (err, rows) {
        rows.forEach(async (row) => {
            if (req.body.EMAIL == `${row.EMAIL}`) {
                const match = await bcrypt.compare(account.PASS, `${row.PASS}`);
                if (!match) {
                    console.log('Incorrect Password');
                    res.redirect('./login');
                } else {
                    res.redirect('/');
                }
            }
        });
    });
};

exports.logout = (req, res, next) => {

};