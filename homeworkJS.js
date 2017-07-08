JS Homework
/**
 * 
 */

var homework = {};

//Q1

homework.fibonacci = function(n){
var a = 0, b = 1, c;
    for(var i = 2 i <= n; i++){
	c = a + b;
	a = b;
	b = c;
    }
return c;
}

//Q2

homework.sort = function(array){
var temp;

for(var i=0; i < array.length -1; i++){  
	for(var j=1; j < array.length; j++){  
		if (array[j-1] > array[j]){ 
			temp = array[j-1];  
			array[j-1] = array[j];  
			array[j] = temp;
		}
	}
}
return array;
}

//Q3

homework.factorial = function(n){
	
	var number = n;
		var increase = 1;
		for (var i = 1; i <= number; i++) {
			increase = increase * i;
		}
		return increase;
}

//Q4

homework.rotateLeft = function(array,n){
	var temp;
 for (var i = 0; i < n; i++) {
        for (var j = 1; j < array.length; j++) {
            temp = array[j];
            array[j] = array[j - 1];
            array[j - 1] = temp;
		}
		}
		return array;
 }

//Q5

homework.balancedBrackets = function(bracketsString){
	
var stack = [];
var pair = { '[' : ']' , '('  : ')', '{' : '}' };
var c;
var balanced = true;

if (bracketsString.length % 2 != 0){
		balanced = false;
}
for (c in bracketsString){
	if(bracketsString[c] in pair){
		stack.push(bracketsString[c]);
	}
	else if (pair[stack.pop()] != bracketsString[c]){
balanced = false;
	}
}
return balanced;	
}





