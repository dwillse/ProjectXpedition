const mongoose = require('mongoose');
const Schema = mongoose.Schema;
const user = require('./user')

const locationSchema = new Schema({
    Country: {type: String },
    Excursion: {type: String},
    Tag: {type: String },
    Lat: {type: String },
    Longit: {type: String},
    website: {type: String},
    description: {type: String},
    reviewScore: {type: String}
}
);
//collection name is stories in the database
module.exports = mongoose.model('Excursions', locationSchema);

const Excursion = mongoose.model('Excursions', locationSchema);

//Excursion.findOne({ ''})



