'use strict';

var gulp = require('gulp');
var jshint = require('gulp-jshint');
var beautify = require('gulp-beautify');

gulp.task('lint', function () {
    return gulp.src('blockbreak.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

gulp.task('beautify', function () {
    gulp.src('blockbreak.js')
        .pipe(beautify({ indentSize: 4 }))
        .pipe(gulp.dest('.'));
});

gulp.task('watch', function () {
    gulp.watch('blockbreak.js', ['lint', 'beautify']);
});

gulp.task('default', [
    'lint',
    'beautify',
    'watch'
]);
