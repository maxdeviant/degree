'use strict';

function prettifyArray(arr) {
    return '[' + arr.toString().replace(/,/g, ', ') + ']';
}