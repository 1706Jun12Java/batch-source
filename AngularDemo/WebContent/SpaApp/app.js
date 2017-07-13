/**
 * 
 */
var app = angular.module('spaApp',['ngRoute']); //we're passing in a dependency!
app.config(function($routeProvider){
	$routeProvider
	.when('/',{
		templateUrl: 'home.html'
	})
	.when('/demo',{
		templateUrl:'demo/demoView.html',
		controller: 'DemoCtrl'
	})
	.when('/quiz',{
		templateUrl:'quiz/quizView.html',
		controller: 'QuizCtrl'	
	})
	.when('/cave',{
		templateUrl:'cave/caveView.html',
		controller: 'CaveCtrl'
	})
	.otherwise({redirectTo: '/'});
});
