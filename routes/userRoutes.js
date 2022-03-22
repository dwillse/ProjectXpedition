const express = require('express');
const controller = require('../controllers/userController');
const {isGuest, isLoggedIn} = require('../middlewares/auth');
const {logInLimiter} = require('../middlewares/rateLimiters');
const {validateSignUp, validateLogIn, validateResult} = require('../middlewares/validator');

const router = express.Router();

//Handles the Login request
router.get("/login", controller.login);

//Handles the create account request
router.get("/new", controller.signUp);


module.exports = router;