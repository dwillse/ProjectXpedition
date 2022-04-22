const express = require('express');
const controller = require('../controllers/locationController');
const {isGuest, isLoggedIn} = require("../middlewares/auth");

const router = express.Router();


//Handles the choosing preferences page
router.get('/preferences', isLoggedIn, controller.pref);

router.post('/preferences', controller.country);

//handles the Rate preferences page
router.get('/ratings', controller.ratings);

//handles the results page
router.get('/results', controller.results);

//Handles the details page
router.get('/locations/:id' , controller.details);


module.exports = router;