const express = require('express');
const controller = require('../controllers/userController');
const router = express.Router();

//Handles the create account request
router.get("/new", controller.new);

//Post to create new account
router.post('/', controller.create);

//Handles the Login request
router.get("/login", controller.getUserLogin);

//Post to login
router.post('/login', controller.login);

//Handles logging out
router.get('/logout', controller.logout);


module.exports = router;