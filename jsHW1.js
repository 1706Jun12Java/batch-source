homework ={};
homework.fibonacci = function(n){
	if(n===1)
        return 1;
	if(n===2)
        return 1;
	return homework.fibonacci(n-1)+homework.fibonacci(n-2);
};
/*
console.log("fib");
console.log(homework.fibonacci(10));
*/
homework.sort=function(array){
    var temp;
    for(var i=0;i<array.length-1;i++){
        for(var j=0;j<array.length-1;j++){
            if(array[j]>array[j+1]){
				temp=array[j];
				array[j]=array[j+1];
				array[j+1]=temp;
            }
        }
    }
};
/*
console.log("sort");
var array=[2,4,5,1,3,1];
homework.sort(array);
for(var i=0;i<array.length;i++){
	console.log(array[i]);
}
*/
homework.factorial=function(n){
    if(n===1)
        return 1;
    if(n===0)
        return 1;
    return n*homework.factorial(n-1);
};
/*
console.log("factorial");
console.log(homework.factorial(3));
*/

homework.rotateLeft = function(array, n) {
	 var arr;
    for(var i=0;i<n;i++){
        arr=array.shift();
        array.push(arr);
    }
};
/*
console.log("rotateLeft 1");
//f([1,2,3,4,5], 1) = [2,3,4,5,1]
var f = [1,2,3,4,5];
homework.rotateLeft(f,1);
for(var i=0;i<f.length;i++){
	console.log(f[i]);
}

console.log("rotateLeft 6");
var f = [1,2,3,4,5];
homework.rotateLeft(f,6);
for(var i=0;i<f.length;i++){
	console.log(f[i]);
}

console.log("rotateLeft 3");
var f = [1,2,3,4,5];
homework.rotateLeft(f,3);
for(var i=0;i<f.length;i++){
	console.log(f[i]);
}
*/
homework.balancedBrackets = function(bracketsString){
	var countPa=0;
	var countBr=0;
	var countSq=0;
	var temp="";
	var tlen=0;
	for(var i=0;i<bracketsString.length;i++){
		
		if("("===bracketsString.substring(i,i+1)){
			countPa+=1;
			temp+=bracketsString.substring(i,i+1);
			tlen+=1;
		}
		else if(")"===bracketsString.substring(i,i+1)){
			countPa-=1;
			if(tlen==0||temp.substring(tlen-1,tlen)!="("){
				return false;
			}
			else{
				temp=temp.substring(0,tlen-1);
				tlen-=1;
			}
		}
		else if("{"===bracketsString.substring(i,i+1)){
			countBr+=1;
			temp+=bracketsString.substring(i,i+1);
			tlen+=1;
			
		}
		else if("}"===bracketsString.substring(i,i+1)){
			countBr-=1;
			if(tlen==0||temp.substring(tlen-1,tlen)!="{"){
				return false;
			}
			else{
				temp=temp.substring(0,tlen-1);
				tlen-=1;
			}
		}
		else if("["===bracketsString.substring(i,i+1)){
			countSq+=1;
			temp+=bracketsString.substring(i,i+1);
			tlen+=1;
		}
		else if("]"===bracketsString.substring(i,i+1)){
			countSq-=1;
			if(tlen==0||temp.substring(tlen-1,tlen)!="["){
				return false;
			}
			else{
				temp=temp.substring(0,tlen-1);
				tlen-=1;
			}
		}
	}
	if(countPa===0&&countBr===0&&countSq===0)
		return true;
	return false;
};
/*
console.log("balancedBrackets");
var str1="(";
var str2=")";
var str3="(()";
var str4="([)]";
var str5="({[]})";
console.log(homework.balancedBrackets(str1));
console.log(homework.balancedBrackets(str2));
console.log(homework.balancedBrackets(str3));
console.log(homework.balancedBrackets(str4));
console.log(homework.balancedBrackets(str5));
*/