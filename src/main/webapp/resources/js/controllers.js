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

angular.module('inspinia').controller('MainCtrl', MainCtrl).controller('LoginController', function($rootScope, $scope, AuthSharedService) {
    $scope.rememberMe = true;
    $scope.login = function() {
	$rootScope.authenticationError = false;
	AuthSharedService.login($scope.username, $scope.password, $scope.rememberMe);
    }
});