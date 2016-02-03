'use strict';

const path = require('path');
const util = require('util');
const express = require('express');
const logger = require('morgan');
const swig = require('swig');

const app = express();

swig.setDefaults({
    cache: false,
    locals: {
        meta: {
            author: 'Marshall Bowers'
        }
    }
});

app.engine('html', swig.renderFile);

app.set('views', path.join(__dirname, 'views'));
app.set('view engine', 'html');

app.use(logger('dev'));
app.use(express.static(path.join(__dirname, 'public'), {
    maxAge: 24 * 60 * 60 * 1000
}));

app.use('/', require('./routes/home'));

app.use((req, res, next) => {
    let err = new Error('Not Found');
    err.status = 404;

    return next(err);
});

app.use((err, req, res, next) => {
    res.status(err.status || 500);

    return res.render('error', {
        title: err.message,
        message: err.message,
        error: err
    });
});

app.set('host', process.env.HOST || '0.0.0.0');
app.set('port', process.env.PORT || 3000);

let server = app.listen(app.get('port'), app.get('host'), () => {
    console.log(util.format('Server listening on %s:%d', app.get('host'), app.get('port')));
});
