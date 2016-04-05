'use strict';

const gulp = require('gulp');
const path = require('path');
const extend = require('extend');
const data = require('gulp-data');
const nano = require('gulp-cssnano');
const concat = require('gulp-concat');
const postcss = require('gulp-postcss');
const markdown = require('gulp-markdown');
const nunjucks = require('gulp-nunjucks');
const sourcemaps = require('gulp-sourcemaps');
const loadJsonFile = require('load-json-file');
const browserSync = require('browser-sync').create();

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
            let baseData = require('./src/site.json');
            let dataPath = path.join(path.dirname(file.path), path.basename(file.path).replace(/\.[^/.]+$/, '') + '.json');

            let pageData = extend(true, baseData, loadJsonFile.sync(dataPath));

            return pageData;
        }))
        .pipe(nunjucks.compile())
        .pipe(gulp.dest('dist'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('html:watch', () => {
    return gulp.watch([
        'src/**/*.json',
        'src/site/**/*.html'
    ], ['html']);
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
        .pipe(gulp.dest('dist/css'))
        .pipe(browserSync.reload({
            stream: true
        }));
});

gulp.task('css:watch', () => {
    gulp.watch(globs.css, ['css']);
});

gulp.task('browser-sync', function() {
    browserSync.init({
        server: {
            baseDir: 'dist/'
        }
    });
});

gulp.task('default', [
    'html',
    'html:watch',
    'css',
    'css:watch',
    'browser-sync'
]);
