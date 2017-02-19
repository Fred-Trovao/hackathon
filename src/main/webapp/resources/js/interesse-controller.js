angular.module('inspinia').controller('InteresseController', function($state, $rootScope, $scope, AuthSharedService, $http) {
    $scope.interesse = {};
    $scope.interesse.tipoDoInteresse = '';
    
	$scope.salvarInformacoes = function(){
		$http.post("/interesses/salvarInteresse",$scope.interesse).success(function(response) {
	        console.log("Interesse cadastrado com sucesso!");
	        swal("Aeee", "Tudo Certo!", "success");
	        $scope.interesse.tipoInteresse = '';
	        $state.go('index.listar-interesses')
	    }).error(function(response) {
	    	swal("Oops...", "Algo deu muito errado :(", "error");
	    });
    	
    }
});