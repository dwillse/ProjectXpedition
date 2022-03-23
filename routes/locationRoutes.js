const express = require('express');
const controller = require('../controllers/locationController');
const router = express.Router();

//router.get('/', controller.index);
router.get('/preferences', controller.choosePref);
//router.post('/', controller.choose);
router.get('/rate', controller.ratePref);
//router.post('/', controller.ratings);

module.exports = router;