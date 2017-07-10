/**
 * Created by ronnnwu on 7/7/17.
 */

var homework = {};

// 1. Return the nth fibonacci number

homework.fibonacci = function (n) {

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

console.log(homework.fibonacci(10));

//  2. Sort array of integers

homework.sort = function (arr){
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


console.log(homework.sort([2,4,5,1,3,1]));

// 3. Return the factorial of n

homework.factorial = function (n){

    var i = 1;
        tot = 1;

    while (i<n){
        i += 1;
        tot *= i;
    }

    return tot;
}

console.log(homework.factorial(3));

// 4. Rotate left


homework.rotateLeft = function (arr, n){
    n = n % arr.length;
    var arr1 = arr.slice(n);

    return arr1.concat(arr.slice(0,n))
}


console.log(homework.rotateLeft([1,2,3,4,5], 1));
console.log(homework.rotateLeft([1,2,3,4,5], 6));
console.log(homework.rotateLeft([1,2,3,4,5], 3));


// 5.  Balanced Brackets

homework.balancedBrackets = function (str){
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


console.log(homework.balancedBrackets('()()'));
console.log(homework.balancedBrackets('({[]})'));

console.log(homework.balancedBrackets('(()'));
console.log(homework.balancedBrackets('([)]'));

document.getElementById('cursorplus').addEventListener("mouseover",
    enhanceCursor, false);

function enhanceCursor() {
    alert('dd');
    event.preventDefault();
    document.getElementById('xPos').innerHTML = event.clientX.toString() ;
    document.getElementById('yPos').innerHTML = event.clientX.toString() ;
}

window.addEventListener("resize", function() {
    document.getElementById('title').innerHTML = "you are resizing"
});

var myEventHandler = function() {
    alert("target:" + event.target.id + "this id " + this.id);
    console.log(event);
}

var divs = document.getElementsByTagName('div');
for (var i = 0; i < divs.length; i++) {
    divs[i].addEventListener("click", myEventHandler() );
}