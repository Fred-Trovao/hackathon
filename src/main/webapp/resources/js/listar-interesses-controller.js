angular.module('inspinia').controller('ListarInteressesController', function($rootScope, $scope, AuthSharedService) {
    $scope.interesse = {};
    $scope.interesse.tipoDoInteresse = 0;
    
	$scope.salvarInformacoes = function(){
		console.log($scope.interesse);
    	
    }
});