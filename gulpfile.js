'use strict';

const gulp = require('gulp');
const nano = require('gulp-cssnano');
const concat = require('gulp-concat');
const postcss = require('gulp-postcss');
const nodemon = require('gulp-nodemon');
const sourcemaps = require('gulp-sourcemaps');

const globs = {
    css: 'src/**/*.css'
};

gulp.task('css', () => {
    return gulp.src(globs.css)
        .pipe(sourcemaps.init())
        .pipe(postcss([
            require('autoprefixer'),
            require('precss')
        ]))
        .pipe(concat('style.min.css'))
        .pipe(nano())
        .pipe(gulp.dest('src/public/css'));
});

gulp.task('css:watch', () => {
    gulp.watch(globs.css, ['css']);
});

gulp.task('nodemon', () => {
    nodemon({
        script: 'src/index.js',
        ext: 'js'
    });
});

gulp.task('default', [
    'css',
    'css:watch',
    'nodemon'
]);
