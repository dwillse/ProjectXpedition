const mongoose = require('mongoose');
const Schema = mongoose.Schema;
//require('@mongoose.js/double');
require('mongoose-double')(mongoose);

const locationSchema = new Schema({
    country: {type: String},
    excursion: {type: String},
    tag: {type: String},
    lat: {type: Schema.Types.Double},
    longit: {type: Schema.Types.Double},
    website: {type: String},
    description: {type: String},
    review: {type: Schema.Types.Double},
    image: {type: String}
}
);
//collection name is stories in the database
module.exports = mongoose.model('Excursions', locationSchema);







