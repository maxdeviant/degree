'use strict';

const gulp = require('gulp');
const postcss = require('gulp-postcss');
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
        .pipe(sourcemaps.write('.'))
        .pipe(gulp.dest('dist'));
});
