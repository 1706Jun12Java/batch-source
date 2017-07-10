// AUTHOR: LEIBNIZ H. BERIHUETE HW

// Question 1
function fibonacci (num) {
    // We need at least two given numbers: 0, and 1
    if(num === 0) {
      return 0;
    }
    else if (num === 1) {
      return 1
    }
    else {
      var sum = 0;
      var beforePrevious = 0;
      var previous = 1;
      var count = 2;
      while(count < num) {
        sum = beforePrevious + previous;
        beforePrevious = previous;
        previous = sum;
      }
      return sum;
    }
};

// Question 2
function arraySort(array) {
  var sorted = false;
  var temp;
  while(!sorted) {
    // Let's assume it is  sorted for now...
    sorted = true;
    for(let i = 1; i < array.length; i++) {
      if(array[i-1] > array[i]) {
          // swap
          temp = array[i-1];
          array[i-1] = array[i];
          array[i] = temp;

          // if a swap occurs it means that it wasn't sorted
          sorted = false; // while loop will continue until a swap never occurs
      }
    }
  }
}


// question 3
function factorial(num) {
  if(num <= 1) {
    return 1;
  }

  //recursive works best in this case.
  return num * factorial(num-1);
}


// Question 4: Helper Function
function rotateLeftOnce(array) {
  var temp = array[0];
  for(let i = 1; i < array.length; i++) {
    array[i-1] = array[i];
  }
  array[array.length-1] = temp;
}

// Question 4:
function rotateLeft(array, num) {
  for(let i = 0; i < num; i++) {
    rotateLeftOnce(array);
  }
}

// Question 5:
function isBalanced(string) {

// if the number of open braces equals the number of close braces, then it should be balanced

  var pStart = '(';
  var pEnd = ')';
  var cStart = '{';
  var cEnd = '}';
  var sStart = '[';
  var sEnd = ']';

  var pStartCount = 0;
  var pEndCount = 0;
  var cStartCount = 0;
  var cEndCount = 0;
  var sStartCount = 0;
  var sEndCount = 0;

  for(let i = 0; i <  string.length; i++) {
    if(string[i] == pStart) {
      pStartCount += 1;
    }
    else if(string[i] == pEnd) {
      pEndCount += 1;
    }

    if(string[i] == cStart) {
      cStartCount += 1;
    }
    else if(string[i] == cEnd) {
      cEndCount += 1;
    }

    if(string[i] == sStart) {
      sStartCount += 1;
    }
    else if(string[i] == sEnd) {
      sEndCount += 1;
    }

    return (pStartCount == pEndCount && cStartCount == cEndCount && sStartCount == sEndCount);
  }


}
