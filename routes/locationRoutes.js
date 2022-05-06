const express = require('express');
const controller = require('../controllers/locationController');
const {isGuest, isLoggedIn} = require("../middlewares/auth");

const router = express.Router();


//Handles the choosing preferences page
router.get('/preferences', isLoggedIn, controller.pref);

router.post('/preferences', isLoggedIn, controller.country);

//handles the Rate preferences page
router.get('/ratings', isLoggedIn, controller.ratings);

router.post('/results', controller.itinerary);

//handles the results page
router.get('/results', isLoggedIn, controller.results);



module.exports = router;