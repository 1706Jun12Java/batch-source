(function() {
    'use strict';
    console.log("app.js");
    angular
        .module('app', ['ngRoute'])
        .config(config);

    function config($routeProvider, $locationProvider) {
        $routeProvider
            .when('/', {
                templateUrl: '/static/views/home.html',
                controller: 'HomeCtrl',
            })
            .when('/login', {
                templateUrl: '/static/views/login.html',
                controller: 'LoginCtrl',
            })
            .otherwise({
                redirectTo: '/'
            });
        $locationProvider.html5Mode(true);
    }

})();