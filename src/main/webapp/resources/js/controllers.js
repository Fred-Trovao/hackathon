/**
 * INSPINIA - Responsive Admin Theme
 *
 */

/**
 * MainCtrl - controller
 */
function MainCtrl() {

    this.userName = 'Example user';
    this.helloText = 'Welcome in SeedProject';
    this.descriptionText = 'It is an application skeleton for a typical AngularJS web app. You can use it to quickly bootstrap your angular webapp projects and dev environment for these projects.';

};

angular.module('inspinia').controller('MainCtrl', MainCtrl)
.controller('LoginController', function($rootScope, $scope, AuthSharedService) {
    $scope.rememberMe = true;
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
});