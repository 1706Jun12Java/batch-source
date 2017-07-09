// Christian Acosta

// 1. Return the nth fibonacci number

var homework = function fibb(num) {
	if (num === 0) {
		return 0;
	}
	if (num === 1) {
		return 1;
	}
	return fibb(num - 1) + fibb(num - 2);
}

// 2. Sort array of integers

var homework = function sort(num) {
	var temp;
	for (var x = 0; x < num.length; x++) {
		for (var y = 0; y < num.length; y++) {
			if (num[x] > num[y]) {
				temp = num[x];
				num[x] = num[y];
				num[y] = temp;
			}
		}
	}
}

// 3. Return the factorial of n

var homework = function fact(num) {
	if (num === 1) {
		return 1;
	}
	return fact(num - 1) * num;
}

// 4. Rotate left

var homework = function shifty(arr, num) {
	var temp;
	for (var x = 0; x < num; x++) {
		temp = arr.shift();
		arr.push(temp);
	}
	return arr;
}

// 5. Balanced Brackets

var homework = function balancedBrackets(str) {
	var arr = str.split("");
	var expected = [];
	for (var i = 0; i < arr.length; i++) {
		console.log(arr[i]);

		switch (arr[i]) {
		case "(":
			expected.push(")");
			break;
		case "{":
			expected.push("}");
			break;
		case "[":
			expected.push("]");
			break;
		default:
			popped = expected.pop();
			if (arr[i] != popped) {
				return false;
			}
			break;
		}
	}
	if (expected.length === 0) {
		return true;
	} else {
		return false;
	}
}