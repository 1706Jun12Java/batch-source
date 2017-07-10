/**
 * 
 */
//1. Return the nth fibonacci number

var homework = {};
homework.fibonacci = function(n){
	if (n<=1){
		return 0;
	} else if (n==2){
		return 1;
	} else 
		return homework.fibonacci(n-1) + homework.fibonacci(n-2);
};

//2. Sort array of integers
//f([2,4,5,1,3,1]) = [1,1,2,3,4,5]
//Don't use the Array sort() method... that would be lame.

homework.sort = function(array){ //I am implementing the bubblesort method
	var arrayLength = array.length;
	var notSwapped = false;
	while(!notSwapped){
		notSwapped = true;
		for (var i=0; i<arrayLength-1; i++){
			if(array[i]>array[i+1]){
				var tmp = array[i];
				array[i] = array[i+1];
				array[i+1] = tmp;
				notSwapped = false;
			}
		}
	}
	return array;
};

/*3. Return the factorial of n
f(0) = 1 f(1) = 1 f(3) = 6
*/

homework.factorial = function(n){
	var result = n;
	if (n==0 || n==1){
		return 1;
	}
	else if (n>1){
		while (n>1) {
			n=n-1;
			result*=n;
		}
		return result;
	}
	else {
		return "Please enter a positive number.";
	}
};

//4. Rotate left
//Given array, rotate left n times and return array
//f([1,2,3,4,5], 1) = [2,3,4,5,1] f([1,2,3,4,5], 6) = [2,3,4,5,1] f([1,2,3,4,5], 3) = [4,5,1,2,3]
//*/
homework.rotateLeft = function(array, n) {
	while(n>0){
		var tmp = array[0];
		array.shift();
		array.push(tmp);
		n--;
	}
	return array;
};

/* 5. Balanced Brackets
A bracket is any one of the following: (, ), {, }, [, or ]
The following are balanced brackets: ()
()() (()) ({[]})
The following are NOT balanced brackets: (
)
(()
([)]
Return true if balanced
Return false if not balanced */

homework.balancedBrackets = function(bracketsString){
	
	function isBalanced(str){
		var strLength = str.length;
		var ourMap = new Map();
		ourMap.set(')', '(');
		ourMap.set('}', '{');
		ourMap.set(']', '[');
		
		var closingBrackets = [...ourMap.keys()];
		var openingBrackets = [...ourMap.values()];
		
		var ourStack = [];
		
		for (var i = 0; i<strLength; i++){
			var char = str[i];
			
			if (openingBrackets.indexOf(char) > -1){
				ourStack.push(char);
			} else if (closingBrackets.indexOf(char) > -1){
				var result = ourMap.get(char);
				
				if (ourStack.length === 0 || (ourStack.pop() !== result)) {
					return false;
				}
			} else {
				continue;
			}
		}
		return (ourStack.length === 0);
		
	}
	
	if(isBalanced(bracketsString)){
		return true;
	} else {
		return false;
	}
};

 
