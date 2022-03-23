// require modules
const express = require('express');
const morgan = require('morgan');
const methodOverride = require('method-override');
const session = require('express-session');
const flash = require('connect-flash');
<<<<<<< HEAD
<<<<<<< HEAD
const locationRoutes = require('./routes/locationRoutes');
const userRoutes = require('./routes/userRoutes');
=======
const connectionRoutes = require('./routes/userRoutes');
//const userRoutes = require('./routes/userRoutes');
>>>>>>> c99ff734f16b1460f198f2f75d9c8558f7f2b88b
=======
const userRoutes = require('./routes/userRoutes');
>>>>>>> 640e4580a2d1aab19b62a95a20f1f993ff699d02

// create app
const app = express();

// configure app
let port = 3000;
let host = 'localhost';
app.set('view engine', 'ejs');
app.set('views', 'views');

app.use(express.static('public'));
app.use(express.urlencoded({extended: true}));
app.use(morgan('tiny'));
app.use(methodOverride('_method'));

// set up routes
app.get('/', (req, res) => {
    res.render('index');
});

<<<<<<< HEAD
app.use('/locations', locationRoutes);
=======
app.get('/preferences', (req, res) => {
    res.render('location/choosePref');
});


<<<<<<< HEAD
//app.use('/connections', connectionRoutes);
>>>>>>> c99ff734f16b1460f198f2f75d9c8558f7f2b88b
//app.use('/users', userRoutes);
=======
app.use('/', userRoutes);

>>>>>>> 640e4580a2d1aab19b62a95a20f1f993ff699d02

app.use((req, res, next) => {
    let err = new Error('The server cannot locate ' + req.url);
    err.status = 404;
    next(err);
});

app.use((err, req, res, next) => {
    console.log(err.stack);
    if (!err.status) {
        err.status = 500;
        err.message = ("Internal Server Error");
    }

    res.status(err.status);
    res.render('error', {error: err});
});

app.listen(port, host, () => {
    console.log('Server is running on port', port);
});