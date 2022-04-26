const mongoose = require('mongoose');
const Schema = mongoose.Schema;

const preferenceSchema = new Schema( {
    country: {type: String},
    chosen: {type: Object},
    userName: {type: Schema.Types.ObjectId, ref: 'UserName'}
},
{timestamps: true}
);

//collection name is connections in the database
module.exports = mongoose.model('Preference', preferenceSchema);