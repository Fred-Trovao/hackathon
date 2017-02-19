angular.module('inspinia').controller('InteresseController', function($rootScope, $scope, AuthSharedService, $http) {
    $scope.interesse = {};
    $scope.interesse.tipoDoInteresse = 0;
    
	$scope.salvarInformacoes = function(){
		$http.post("/interesses/salvarInteresse",$scope.interesse).success(function(response) {
	        console.log("Interesse cadastrado com sucesso!");
	    }).error(function(response) {
	    	console.log("Error");
	    });
    	
    }
});