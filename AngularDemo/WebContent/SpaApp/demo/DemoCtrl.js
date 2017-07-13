angular.module('spaApp').controller('DemoCtrl',function($scope,$location,$interval){
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