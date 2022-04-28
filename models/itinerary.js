const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const itinerarySchema = new Schema( {
    excursion1: {type: Schema.Types.ObjectId, ref: 'Exc1'},
    excursion2: {type: Schema.Types.ObjectId, ref: 'Exc2'},
    excursion3: {type: Schema.Types.ObjectId, ref: 'Exc3'},
    excursion4: {type: Schema.Types.ObjectId, ref: 'Exc4'},
    excursion5: {type: Schema.Types.ObjectId, ref: 'Exc5'},
    userName: {type: Schema.Types.ObjectId, ref: 'UserName'}
},
{timestamps: true}
);

//collection name is connections in the database
module.exports = mongoose.model('Itinerary', itinerarySchema);