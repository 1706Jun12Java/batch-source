/**
 * Created by ronnnwu on 7/7/17.
 */

// 1. Return the nth fibonacci number

function fibonacci(n) {

    var i = 0,
        j = 1,
        k = 1;
    while (k<n){
        var temp = j;
        j = i + j;
        i = temp;
        k += 1;
    }
    return j
}

console.log(fibonacci(10));

//  2. Sort array of integers

function f(arr){
    for (var i = 0; i<arr.length-1; i++){
        for (var j = i; j<arr.length; j++){
            if (arr[i] > arr[j]){
                var temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
    }
    return arr;
}

var arr = [2,4,5,1,3,1];

console.log(f(arr));

// 3. Return the factorial of n

function factorial(n){

    var i = 1;
        tot = 1;

    while (i<n){
        i += 1;
        tot *= i;
    }

    return tot;
}

console.log(factorial(3));

// 4. Rotate left


function rotateLeft(arr, n){
    n = n % arr.length;
    var arr1 = arr.slice(n);

    return arr1.concat(arr.slice(0,n))
}


console.log(rotateLeft([1,2,3,4,5], 1));
console.log(rotateLeft([1,2,3,4,5], 6));
console.log(rotateLeft([1,2,3,4,5], 3));


// 5.  Balanced Brackets

function balancedBrackets(str){
    var stack = [],
        BracksPair = {
            '(' : ')',
            '[' : ']',
            '{' : '}'
        },
        res = true;

    for (var c in str){
        if (str[c] in BracksPair){

           stack.push(str[c]);
        }
        else{

            if (stack.length === 0){
                res = false;
                break;
            }
            var l = stack.pop();
            if (BracksPair[l] !== str[c]){
                res = false;
                break;
            }

        }
    }

    if (stack.length !== 0){
        res = false;
    }
    return res;
}


console.log(balancedBrackets('()()'));
console.log(balancedBrackets('({[]})'));

console.log(balancedBrackets('(()'));
console.log(balancedBrackets('([)]'));