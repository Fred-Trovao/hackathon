angular.module('inspinia').controller('ListarInteressesController', function($rootScope, $scope, AuthSharedService, $http, $uibModal) {
    
	this.listarInteresses = function(){
		
		$http({
			method: 'GET',
			url: '/listar-interesses'
				
		}).then(function sucesso(response){
			
		});
	}
	
	this.listarInteresses();
	
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
	
	$scope.listaInteressados = [
		{
			id : 1,
			valorDoInteresse : 2000.00,
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
			valorDoInteresse : 34234.00,
			valorDoRepasse : 3400.51,
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
	
	$scope.abrirModal = function (usuario) {
        var modalInstance = $uibModal.open({
            templateUrl:'resources/views/common/modal.html',
            controller: ModalInstanceCtrl,
            windowClass: "animated flipInY",
            resolve : {
            	items : function (){
            		return usuario;
            	}
            }
        });
    };
	
	function ModalInstanceCtrl ($scope, $uibModalInstance, items) {
		
		$scope.usuarioModal = items;
		console.log($scope.usuarioModal);
		
	    $scope.ok = function () {
	        $uibModalInstance.close();
	    };

	    $scope.cancel = function () {
	        $uibModalInstance.dismiss('cancel');
	    };


	    $scope.states = [
	        'Alabama',
	        'Alaska',
	        'Arizona',
	        'Arkansas',
	        'California',
	        'Colorado',
	        'Connecticut',
	        'Delaware',
	        'Florida',
	        'Georgia',
	        'Hawaii',
	        'Idaho',
	        'Illinois',
	        'Indiana',
	        'Iowa',
	        'Kansas',
	        'Kentucky',
	        'Louisiana',
	        'Maine',
	        'Maryland',
	        'Massachusetts',
	        'Michigan',
	        'Minnesota',
	        'Mississippi',
	        'Missouri',
	        'Montana',
	        'Nebraska',
	        'Nevada',
	        'New Hampshire',
	        'New Jersey',
	        'New Mexico',
	        'New York',
	        'North Carolina',
	        'North Dakota',
	        'Ohio',
	        'Oklahoma',
	        'Oregon',
	        'Pennsylvania',
	        'Rhode Island',
	        'South Carolina',
	        'South Dakota',
	        'Tennessee',
	        'Texas',
	        'Utah',
	        'Vermont',
	        'Virginia',
	        'Washington',
	        'West Virginia',
	        'Wisconsin',
	        'Wyoming'
	    ];

	};

	

});