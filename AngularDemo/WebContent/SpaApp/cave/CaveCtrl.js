/**
 * 
 */
angular.module('spaApp').controller('CaveCtrl',function($scope,$interval,$http){
	//preload caves
	getCaves();
	$scope.CAVEBASE= "http://localhost:8085/SpringDataDemo/cave/";
	$interval(function(){
		getCaves();
	},10000);
	//check when updating which boxes are selected for removal
	
	$scope.remove = function(){
		var oldCaves = $scope.caves;
		angular.forEach(oldCaves, function(cave){
			if ((cave.rm)){
				$http.delete($scope.CAVEBASE+cave.id)
				.then(function(response){
					console.log(response.data);
				});
			}
		});
	};
	
	$scope.addCave = function(){
		if ($scope.newCaveName) {
			$http({
				method: 'POST',
				url: $scope.CAVEBASE,
				data: {"name":$scope.newCaveName}
			});
			$scope.newCaveName="";
			$scope.inputStyle={background:'white'};
		} else {
			$scope.inputStyle={background:'red'};
		}
	};
	
	function getCaves(){
		$http({method:"GET",url:$scope.CAVEBASE+"all"})
		.then(function(response){
			$scope.caves=response.data;
		}, function(response){
			return{
				name:"ERROR",
				description:"response.data"
			}
		});
	}
	
});