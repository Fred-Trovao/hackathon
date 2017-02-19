angular.module('inspinia').controller('ListarInteressesController', function($rootScope, $scope, AuthSharedService, $http) {
    
	
	$scope.listaInteresse = [
		{
			id : 1,
			nome : 'MacBook Pro',
			link : 'https://goo.gl/2TteRf',
			valorDoInteresse : 34234.00,
			valorDoRepasse : 3400.51,
			usuario : {
				endereco : {
					cidade : 'João Pessoa',
					estado : 'PB',
				},
				nome : 'Monica Smith',
				email : 'monica@msn.com',
				telefone : '83 99999-9999',
			}
		},
		{
			id : 2,
			nome : 'Projeto de interiores',
			valorDoInteresse : 34234.00,
			valorDoRepasse : 3400.51,
			valorDaParcela : 500.00,
			quantidadeDeParcelas : 5,
			usuario : {
				endereco : {
					cidade : 'João Pessoa',
					estado : 'PB',
				},
				nome : 'Mark Johnson',
				email : 'mark@msn.com',
				telefone : '83 88888-8888',
			}
		},
		
	];
	

});