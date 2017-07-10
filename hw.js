var homework = {};

homework.fibonacci = function(n) {
	if (n === 0) {
		return 0;
	}
	if (n <= 2) {
		return 1;
	} else {
		return this.fibonacci(n - 1) + this.fibonacci(n - 2);
	}
}

homework.sort = function(array) {
	var swapped;
	do {
		swapped = false;
		for (var i = 0; i < array.len - 1; i++) {
			if (array[i] > array[i + 1]) {
				var temp = array[i];
				array[i] = array[i + 1];
				array[i + 1] = temp;
				swapped = true;
			}
		}
	} while (swapped);
}

homework.factorial = function(n) {
	var f = 1;
	for (var j = 1; j <= n; j++) {
		f = f * j;
	}
	return f;
}

homework.rotateLeft = function(array, n) {
	var step;
	for (var x = 0; x < n; x++) {
		for (var y = 1; y < array.len; y++) {
			step = array[y];
			array[y] = array[y - 1];
			array[y - 1] = step;
		}
	}
	return array;
}

homework.balancedBrackets = function(bracketsString) {
	var bool = true; 
	var stack = []
	var Brackets = {'(' : ')','[' : ']','{' : '}'};
	for ( var i in bracketsString) {
		if (bracketsString[i] in Brackets) {
			stack.push(bracketsString[i]);
		} else {
			if (stack.len === 0) {
				bool = false;
				break;
			}
			var temp = stack.pop();
			if (Brackets[temp] !== bracketsString[i]) {
				bool = false;
				break;
			}
		}
	}
	if (stack.length !== 0) {
		bool = false;
	}
	return bool;
}