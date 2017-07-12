var app = angular.module('DemoApp',[]);
app.controller('DivisionCtrl',function($scope){
	$scope.data = {number:0,divisor:0,result:0};
	$scope.divisionNeeded = function(){
		$scope.data.result = $scope.data.number / $scope.data.divisor;
	}
});
app.controller('PersonCtrl',function($scope){
	$scope.names = [{name:'John',hometown:'Sacramento'},
		{name:'Bob',hometown:'California'},{name:'JJ',hometown:'Africa'}];
	$scope.justNames = ['John','Bob','Jessica'];
	//create a function to handle a mouseover event on a table of names (or anything, really)
	$scope.mouseLocation = function(e){
		$scope.x = e.clientX;
		$scope.y = e.clientY;
	};
});
app.controller('ColorCtrl',function($scope){
	$scope.myColor = '#42a5f5';
});
app.controller('ServiceCtrl',function($scope,$location,$interval){
	$scope.myUrl = $location.absUrl();
	$scope.theTime = new Date().toLocaleTimeString();
	$interval(function(){
		$scope.theTime = new Date().toLocaleTimeString();
	},1000);
	$scope.showTime = false;
	$scope.toggleTime = function(){
		$scope.showTime = !$scope.showTime;
	};
});
app.directive('superCoolCustomDir',function(){
	return {
		restrict:"EACM",
		template: '<h3>Made by a directive!</h3>'
	};
});
/*app.directive('div',function(){
	return {
		template: '<h3>ABSOLUTELY BARBARIC!</h3>'
	};
});*/
app.filter('myFormat',function(){
	return function(x){
		var i, c, txt="";
		for (i=0; i<x.length; i++){
			c = x[i];
			if (i%2==0){
				c = c.toUpperCase();
			}
			txt +=c;
		}
		return txt;
	};
});
