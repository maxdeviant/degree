'use strict';

const gulp = require('gulp');
const path = require('path');
const data = require('gulp-data');
const nano = require('gulp-cssnano');
const concat = require('gulp-concat');
const postcss = require('gulp-postcss');
const markdown = require('gulp-markdown');
const nunjucks = require('gulp-nunjucks');
const sourcemaps = require('gulp-sourcemaps');

const globs = {
    pages: [
        'src/site/**/*.html',
        '!src/site/_layouts/*.html'
    ],
    markdown: '',
    css: 'src/css/**/*.css'
};

gulp.task('html', () => {
    return gulp.src(globs.pages)
        .pipe(data((file) => {
            let dataPath = path.join(path.dirname(file.path), path.basename(file.path).replace(/\.[^/.]+$/, '') + '.json');

            return require(dataPath);
        }))
        .pipe(nunjucks.compile())
        .pipe(gulp.dest('dist'));
});

gulp.task('markdown', () => {

});

gulp.task('css', () => {
    return gulp.src(globs.css)
        .pipe(sourcemaps.init())
        .pipe(postcss([
            require('autoprefixer'),
            require('precss')
        ]))
        .pipe(concat('style.min.css'))
        .pipe(nano())
        .pipe(gulp.dest('dist/css'));
});

gulp.task('css:watch', () => {
    gulp.watch(globs.css, ['css']);
});

gulp.task('default', [
    'html',
    'css',
    'css:watch'
]);
