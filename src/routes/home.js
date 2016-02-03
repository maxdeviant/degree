'use strict';

const express = require('express');

const router = express.Router();

router.route('/home')
    .get((req, res, next) => {
        let locals = {};

        return res.render('index', locals, (err, template) => {
            return res.send(template);
        });
    });

module.exports = router;
