const mongoose = require('mongoose');
const Schema = mongoose.Schema;
require('./location');

const itinerarySchema = new Schema( {
    excursion1: {type: Schema.Types.ObjectId, ref: 'Excursions'},
    excursion2: {type: Schema.Types.ObjectId, ref: 'Excursions'},
    excursion3: {type: Schema.Types.ObjectId, ref: 'Excursions'},
    excursion4: {type: Schema.Types.ObjectId, ref: 'Excursions'},
    excursion5: {type: Schema.Types.ObjectId, ref: 'Excursions'},
    userName: {type: Schema.Types.ObjectId, ref: 'User'}
},
{timestamps: true}
);

//collection name is connections in the database
module.exports = mongoose.model('Itinerary', itinerarySchema);