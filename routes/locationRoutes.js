const express = require('express');
const controller = require('../controllers/locationController');
const {isGuest, isLoggedIn} = require("../middlewares/auth");

const router = express.Router();

//Handles the choosing preferences page
router.get("/preferences", isLoggedIn, controller.pref);

//handles the Rate preferences page
router.get('/ratings', controller.ratings);

//Handles the details page
router.get('/locations/:id' , controller.details);

//handles the results page
router.get('/results', controller.results);


module.exports = router;