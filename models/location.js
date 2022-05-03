const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const user = require('./user')

const locationSchema = new Schema({
    COUNTRY: {type: String},
    EXCURSION: {type: String},
    TAG: {type: String},
    LAT: {type: String},
    LONGIT: {type: String},
    WEBSITE: {type: String},
    DESCR: {type: String},
    REVIEWSCORE: {type: String}
}
);
//collection name is stories in the database
module.exports = mongoose.model('Excursions', locationSchema);







