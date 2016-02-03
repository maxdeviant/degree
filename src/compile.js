'use strict';

const fs = require('fs');
const path = require('path');
const swig = require('swig');

function compilePage(page) {
    page.locals.title = page.title;

    return render(path.join('views', page.view), page.locals).then((template) => {
        let filePath = page.route.endsWith('/') ? page.route + 'index.html' : page.route + '.html';

        return writeToFile(path.join('../dist', filePath), template);
    });
}

function render(pathName, locals) {
    return new Promise((resolve, reject) => {
        pathName = pathName.endsWith('.html') ? pathName : pathName + '.html';

        swig.renderFile(pathName, locals, (err, template) => {
            if (err) {
                return reject(err);
            }

            return resolve(template);
        });
    });
}

function writeToFile(filePath, contents) {
    return new Promise((resolve, reject) => {
        let writer = fs.createWriteStream(filePath);

        writer.write(contents);

        writer.on('error', (err) => {
            return reject(err);
        });

        writer.on('finish', () => {
            return resolve(true);
        })
    });
}

swig.setDefaults({
    locals: {
        meta: {
            author: 'Marshall Bowers'
        }
    }
});

const pages = require('./manifest');

let promises = [];

pages.forEach((page) => {
    promises.push(compilePage(page));
});

Promise.all(promises).then((results) => {
    console.log('Finished')
}).catch((err) => {
    console.log(err);
});
