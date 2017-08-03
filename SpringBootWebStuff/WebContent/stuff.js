/**
 * 
 */
var app = angular.module("app",['ngRoute']);

app.config(['$routeProvider',function($routeProvider) {
	$routeProvider
		.when('/',{
			templateUrl: '/SpringBootWebStuff/Home.html',
			controller: 'FirstController'
		})
		.when('/Book', {
			templateUrl: '/SpringBootWebStuff/Books.html',
			controller: 'FirstController'
		})
		.when('/Authors', {
			templateUrl: '/SpringBootWebStuff/Authors.html',
			controller: 'FirstController'
		});
}]);

app.controller('FirstController', function($scope,$http) {
	var books;
	var authors;
	var getBooks= function($http){
		$http({
		  method: 'GET',
		  url: 'http://localhost:8083/all'
		}).then(function successCallback(response) {
			books= response;
		  }, function errorCallback(response) {
			  books = 'whoops';
		  });
	}
	var getAuthors= function($http){
		$http({
		  method: 'GET',
		  url: 'http://localhost:8083/author/all'
		}).then(function successCallback(response) {
			authors= response;
		  }, function errorCallback(response) {
		    authors = 'whoops';
		  });
	}
});