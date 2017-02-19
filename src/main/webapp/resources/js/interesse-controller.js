angular.module('inspinia').controller('InteresseController', function($state, $rootScope, $scope, AuthSharedService, $http) {
    $scope.interesse = {};
    $scope.interesse.tipoDoInteresse = '';
    
	$scope.salvarInformacoes = function(){
		if($scope.interesse.valorDoInteresse > 0 ){
		$http.post("/interesses/salvarInteresse",$scope.interesse).success(function(response) {
	        console.log("Interesse cadastrado com sucesso!");
	        swal("Aeee", "Tudo Certo!", "success");
	        $scope.interesse.tipoInteresse = '';
	        $state.go('index.listar-interesses')
	    }).error(function(response) {
	    	swal("Oops...", "Algo deu muito errado :(", "error");
	    });
		}
		else{
			swal("Ta de brincadeira!", "Informe pelo menos algum valor! :(", "error");
		}
    	
    }
});