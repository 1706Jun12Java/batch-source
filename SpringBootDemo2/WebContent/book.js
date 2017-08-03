angular.module('consume', []).controller('getBooks', function($scope, $http) {
	$http.get('http://localhost:8083/book/getAll').then(function(response) {
		$scope.books = response.data;
	});
});