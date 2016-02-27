'use strict';

var markdown = require('markdown').markdown;

var App = function () {
    this.convert = function (data) {
        return markdown.toHTML(data);
    };
};

module.exports = App;
