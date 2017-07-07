var homework = {};

console.log("~~~~~~~~~~~~~~~~~~ Fibonacci");

homework.fibonacci = function (n) {
    var first = 0, second = 1, temp = 0;

    for (var i = 0; i < n; i++) {
        temp = second;
        second += first;
        first = temp;
    }

    return first;
}

console.log(homework.fibonacci(0));
console.log(homework.fibonacci(1));
console.log(homework.fibonacci(10));

console.log("~~~~~~~~~~~~~~~~~~ Sort");


homework.sort = function (arr) {

    for (var i = 0; i < arr.length - 1; i++) {
        var minIndex = i;
        for (var j = i + 1; j < arr.length; j++) {
            if (arr[j] < arr[minIndex]){
                minIndex = j; 
            }
        }

        var temp = arr[minIndex];
        arr[minIndex] = arr[i];
        arr[i] = temp;
    }
}

var arr = [2,4,5,1,3,1];

homework.sort(arr);


console.log(arr);

console.log("~~~~~~~~~~~~~~~~~~ Factorial");

homework.factorial = function (n){
    var value = n;

        while(n > 1){
            n--;
            value *= n;
        }

    return value;
}

console.log(homework.factorial(0));
console.log(homework.factorial(1));
console.log(homework.factorial(3));

console.log("~~~~~~~~~~~~~~~~~~ Rotate Left");
//  f([1,2,3,4,5], 1) = [2,3,4,5,1]
//  f([1,2,3,4,5], 6) = [2,3,4,5,1]
//  f([1,2,3,4,5], 3) = [4,5,1,2,3]

homework.rotateLeft = function(arr, n) {
    var temp;
    for (var i = 0; i < n; i++){
        temp = arr.shift();
        arr.push(temp);
    }
    return arr;
}


var arr1 = homework.rotateLeft([1,2,3,4,5], 1);
var arr2 = homework.rotateLeft([1,2,3,4,5], 6);
var arr3 = homework.rotateLeft([1,2,3,4,5], 3);

console.log(arr1);
console.log(arr2);
console.log(arr3);

console.log("~~~~~~~~~~~~~~~~~~ balancedBrackets");

homework.balancedBrackets = function (bracket){
    var arr = [];
    if (bracket === undefined || bracket === null)
        return false;
    
    for (var i = 0; i < bracket.length; i++) {
        if (bracket[i] === '{' || bracket[i] === '[' || bracket[i] === '(')
            arr.push(bracket[i]);
        else if (bracket[i] === '}'){
            if (arr.pop() !== '{')
                return false;
        } 
        else if (bracket[i] === ']'){
            if (arr.pop() !== '[')
                return false;
        }
        else if (bracket[i] === ')'){
            if (arr.pop() !== '(')
                return false;
        }
    }

    if (arr.length === 0)
        return true;
    return false;
}

//  (
//  )
//  (()
//  ([)]

console.log(homework.balancedBrackets('()'), ' for ()');
console.log(homework.balancedBrackets('()()'), ' for ()()');
console.log(homework.balancedBrackets('(())'), ' for (())');
console.log(homework.balancedBrackets('({[]})'), ' for ({[]})');
console.log(homework.balancedBrackets('('), ' for (');
console.log(homework.balancedBrackets(')'), ' for )');
console.log(homework.balancedBrackets('(()'), ' for (()');
console.log(homework.balancedBrackets('([)]'), ' for ([)]');
