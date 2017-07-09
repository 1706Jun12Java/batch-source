
var homework = {};

homework.fibonacci = function(n){
	if(n === 0){
		return 0;
	}
	var prev = 0;
	var next = 1;
	var sum;
for(var i = 1; i < n; i++){
	sum = prev + next;
	prev = next;
	next = sum;
}
	return sum;
};

homework.sort = function(array) {
	if(array.constructor !== Array){
		return 'NO';
	}
	for(var i = 0; i < array.length; i++){
		for(var j = 0; j< array.length; i++){
			if(array[j+1] < array[j]){
				var temp = array[j];
				array[j] = array[j+1];
				array[j+1] = tmp;
			}
		}
	}
};

homework.factorial = function(n){
	var sum = 1;
	for(var i = 1; i <= n ; i++){
		sum = sum * i;
	}
	return sum;
};

homework.rotateLeft = function(array, n) {
	if(array.constructor !== Array){
		return 'NO';
	}
	for(var i = 0; i < n ; i++){
		var tmp = array.shift;
		array.push(tmp);
	}
};

homework.balancedBrackets = function(bracketsString){
	var brack = bracketsString.split();
	var balance = 0;
	for(var i = 0; i < brack.length; i++){
		switch(brack[i]){
			case "[": 
			case "{":
			case "(": balance = balance + 1;
			break;
			case "]": 
			case "}":
			case ")": balance = balance - 1;
			break;
		}
	}
	if(balance === 0){
		return true;
	}else{
		return false;
	}
};
