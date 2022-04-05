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

module.exports = con;