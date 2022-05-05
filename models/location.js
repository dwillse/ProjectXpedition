const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const locationSchema = new Schema({
    country: {type: String},
    excursion: {type: String},
    tag: {type: String},
    lat: {type: String},
    longit: {type: String},
    website: {type: String},
    description: {type: String},
    review: {type: String},
    image: {type: String}
}
);
//collection name is stories in the database
module.exports = mongoose.model('Excursions', locationSchema);







