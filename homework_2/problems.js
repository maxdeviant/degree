/*
 *  Problem 1
 *  Create a variable to store the radius of a circle. Assign the variable some value. Calculate and display the the circle's diameter, circumference, and area.
 */
function problemOne() {
    var radius = 50;

    var diameter = 2 * radius;
    var circumference = Math.PI * diameter;
    var area = Math.PI * radius * radius;

    return 'Diameter: ' + diameter + '<br>Circumference: ' + circumference + '<br>Area: ' + area;
}

/*
 *  Problem 2
 *  Write a function that takes one argument, a temperature in Celsius, and returns that temperature in Fahrenheit. Print out the resulting temperature. Feel free to hard code the Celsius temperature, or if you wish accept the temperature as input via a text box.
 */
function problemTwo(celcius) {
    var fahrenheight = celcius * 9 / 5 + 32;

    return '' + fahrenheight + '&nbsp;&deg;F';
}

/*
 *  Problem 3
 *  Write a function that takes one argument, the user's birthday year. The function shall return an array whose elements are the possible ages of the user. Only the user's birthday should be hardcoded -- not 2014. Utilize JavaScript functions to return the current calendar year (2014).
 */
function problemThree() {

}

/*
 *  Problem 4
 *  Write a function that takes one numeric argument and displays that number reversed in an alert box. (i.e. 12345 -> 54321)
 */
function problemFour(number) {
    alert(number.toString().split('').reverse().join(''));

    return 'Done.';
}

/*
 *  Problem 5
 *  Write a function that generates three random numbers and outputs the largest number.
 */
function problemFive() {
    var numbers = [];

    for (var i = 0; i < 3; i++) {
        numbers.push(Math.floor(Math.random() * 1000) + 1);
    }

    return '[' + numbers.toString().replace(/,/g, ', ') + ']<br>' + Math.max.apply(Math, numbers);
}

/*
 *  Problem 6
 *  Write a function that generates all combinations of a given String, and returns the combinations as elements in an array. (i.e. 'bad' -> ['b','ba','bad','a','ad','d'])
 */
function problemSix() {

}

/*
 *  Problem 7
 *  Write a function that accepts one argument and returns the typeof the argument.
 */
function problemSeven(arg) {
    return typeof arg;
}

/*
 *  Problem 8
 *  Write a function that takes an array of numbers and finds the second lowest and second greatest numbers. The function should return an object with this information.
 */
function problemEight() {

}

/*
 *  Problem 9
 *  Write a function that takes two arguments, an array with numeric elements and a number. The function should iterate over the array, and in-place, delete all elements in the array that are smaller than the second argument number.
 */
function problemNine(arr, n) {
    for (var i = 0; i < arr.length; i++) {
        if (arr[i] < n) {
            arr.splice(i, 1);
            i--;
        }
    }

    return '[' + arr.toString().replace(/,/g, ', ') + ']';
}

/*
 *  Problem 10
 *  Write a function that takes one numeric argument, n, and outputs the first n happy numbers.
 */
function problemTen() {

}

/*
 *  Problem 11
 *  Duplicate your above function so that it also incorporates a try/catch block to check for a negative n.
 */
function problemEleven() {

}

/*
 *  Problem 12
 *  Write a function that accepts a number as input and returns a numeric-like string that has "pluses" + inserted between every two even digits. (i.e. 2647522 -> 2+6+4752+2)
 */
function problemTwelve() {

}

/*
 *  Problem 13
 *  Write a function that accepts an array argument and returns the most frequent item. (i.e. [5, 'a', 'a', 'a', 3, 1, 'a', 4, 'a', 4, 4] -> "a 5")
 */
function problemThirteen() {

}

/*
 *  Problem 14
 *  Write a function that prints the properties of an object by iterating over them.
 */
function problemFourteen() {

}
