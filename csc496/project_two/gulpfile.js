'use strict';

var gulp = require('gulp');
var jshint = require('gulp-jshint');
var beautify = require('gulp-beautify');

gulp.task('lint', function () {
    return gulp.src('js/game.js')
        .pipe(jshint())
        .pipe(jshint.reporter('default'));
});

gulp.task('beautify', function () {
    gulp.src('js/game.js')
        .pipe(beautify({ indentSize: 4 }))
        .pipe(gulp.dest('js'));
});

gulp.task('watch', function () {
    gulp.watch('js/game.js', ['lint', 'beautify']);
});

gulp.task('default', [
    'lint',
    'beautify',
    'watch'
]);
