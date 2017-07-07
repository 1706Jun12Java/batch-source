/**
 * Using ES6
 */


// Question 1
function fibonacciNth(number) {
    if (isNaN(number))
        throw "That's not a number";
    if (number === 0)
        return 0;

    if (number === 1 || number === 2)
        return 1;

    return fibonacciNth(number - 1) + fibonacciNth(number - 2);
}

// ======================================================================================


// Question 2
function sortArray(array) {
    if (!Array.isArray(array))
        throw "That's not an array";

    for (let i = array.length - 1; i > 1; i--) {
        for (let j = 0; j < i; j++) {
            if (array[j] > array[j + 1]) {
                let temp = array[j];
                array[j] = array[j + 1];
                array[j + 1] = temp;
            }
        }
    }
}

// =============================================================================================

// Question 3
function factorial(number) {
    if (isNaN(number))
        throw "Not a number";

    if (number === 0 || number === 1)
        return 1;

    return number * factorial(number - 1);
}

// Question 4
function leftArray(array, n) {
    if (!Array.isArray(array))
        throw "Not an array";

    if (isNaN(n))
        throw "Not a number";

    while (n-- > 0) {
        let temp = array[0];

        for (let i = 0; i < array.length - 1; i++) {
            array[i] = array[i + 1];
        }

        array[array.length - 1] = temp;
    }
}

// ==================================================================================

// Question 5
function isBalance(str) {
    if (str === "")
        return true;

    if (str.length % 2 !== 0)
        return false;

    let brackets = str.split("");

    let openBrackets = [];

    for (let i = 0; i < brackets.length; i++) {
        if (isOpen(brackets[i]))
            openBrackets.push(brackets[i]);
        else if (isClose(brackets[i])) {
            if (openBrackets.length < 1)
                return false;

            if (!isMatch(openBrackets.pop(), brackets[i]))
                return false;
        }
    }

    return true;
}

function isOpen(bracket) {
    return (bracket === "(" || bracket === "{" || bracket === "[");
}

function isClose(bracket) {
    return (bracket === ")" || bracket === "}" || bracket === "]");
}

function isMatch(openBracket, closeBracket) {
    if (openBracket === "(" && closeBracket === ")")
        return true;
    else if (openBracket === "{" && closeBracket === "}")
        return true;
    else if (openBracket === "[" && closeBracket === "]")
        return true;

    return false
}
