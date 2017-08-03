(function() {
    'use strict';

    angular
        .module('app')
        .controller('LoginCtrl', ['$scope', '$http', function($scope, $http){
            $scope.getBooks = function() {
                $http.get('http://localhost:8083/lib/author/all')
                    .then(function(response) {
                        $scope.bookData = response.data;
                        console.log($scope.bookData);
                    });
            };
        }]);
})();