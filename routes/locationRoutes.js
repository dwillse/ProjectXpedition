const express = require('express');
const controller = require('../controllers/locationController');
const {isGuest, isLoggedIn} = require("../middlewares/auth");

const router = express.Router();

router.post('/preferences', controller.country);

//Handles the choosing preferences page
router.get('/preferences', isLoggedIn, controller.pref);

//Handles posting the data from preferences page
router.post('/ratings', controller.select);

//handles the Rate preferences page
router.get('/ratings', controller.ratings);

//handles the results page
router.get('/results', controller.results);

//Handles posting the data from ratings page
router.post('/results', controller.rate);

//Handles the details page
router.get('/locations/:id' , controller.details);


module.exports = router;