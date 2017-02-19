/**
 * INSPINIA - Responsive Admin Theme
 *
 */

/**
 * MainCtrl - controller
 */
function MainCtrl() {

    this.userName = 'Usuario';
    this.helloText = 'Welcome in SeedProject';
    this.descriptionText = 'It is an application skeleton for a typical AngularJS web app. You can use it to quickly bootstrap your angular webapp projects and dev environment for these projects.';

    this.teste = function() {
	console.log("clicou");
    };
};

angular.module('inspinia').controller('MainCtrl', MainCtrl)
.controller('LoginController', function($rootScope, $scope, AuthSharedService, $state) {
    $scope.rememberMe = true;
    $scope.usuario
    
    $scope.cadastrarUsuario = function(){
    	console.log("ae");
    	$state.go('cadastrar-usuario');
    }
    
    $scope.efetuarCadastro = function(){
    	if($scope.usuario != null){
    		$http.post("/usuarios/salvarUsuario",$scope.usuario).success(function(response) {
    	        console.log("Usuario cadastrado com sucesso!");
    	        swal("Aeee", "Usuario cadastrado com sucesso!", "success");
    	    }).error(function(response) {
    	    	swal("Oops...", "Algo deu muito errado :(", "error");
    	    });
    		}
    }
    
    $scope.login = function() {
	$rootScope.authenticationError = false;
	AuthSharedService.login($scope.username, $scope.password, $scope.rememberMe);
    }})
.controller('ErrorController', function($scope, $routeParams) {
    $scope.code = $routeParams.code;

    switch ($scope.code) {
    case "403":
	$scope.message = "Oops! Você não tem permissão para acessar essa página."
	break;
    case "404":
	$scope.message = "Recurso não encontrado."
	break;
    default:
	$scope.code = 500;
	$scope.message = "Oops! Um erro inesperado aconteceu."
    }
}).controller('LogoutController', function (AuthSharedService, $scope) {
    
    $scope.logout = function() {
	AuthSharedService.logout();	
    }
});