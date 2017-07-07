var homework = {};

//#1
homework.fibonacci = function(n){
  var first=0;
  var second=1;
  var nth=0;
  while(n>1){
    nth = first+second;
    first=second;
    second=nth;
    n-=1;
  }
  return nth;
};

//#2
homework.sort = function(l){
  var array = l;
  for(var i=0; i<array.length-1; i++){
    for(var j=0; j<array.length-1; j++){
      if (array[j]>array[j+1]){
        var temp = array[j];
        array[j] = array[j+1];
        array[j+1] = temp;
      }
    }

  }
  return array;
};


//#3
homework.factorial = function(n){
  if(n==0 || n==1){
    return 1;
  }else{
    var res = 1;
    while(n>0){
      res*=n;
      n-=1;
    }
    return res;
  }
};

//#4
homework.rotateLeft = function(array, n){
  for(var i= 0; i<n;i++){
    array.push(array[0]);
    array.splice(0,1);
  }
  return array;
};

//#5
homework.balancedBrackets = function(bracketsString){
    var types = ['(', ')', '{', '}', '[', ']'];
    var order = [];
    for(var i=0;i<bracketsString.length;i++){
      var idx = types.indexOf(bracketsString[i]);
      if(idx%2==0){
          order.push(idx);
      }else{
        if(order[order.length-1]!=idx-1){
          return false;
        }else{
          order.pop();
        }
      }
    }
    if(order.length==0){
      return true;
    }
    return false;
};
