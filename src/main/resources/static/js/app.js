'use strict';

//Criacao do modulo principal da aplicacao
var appCliente = angular.module("appCliente", ['ngRoute']);

appCliente.config(['$routeProvider', function($routeProvider) {
	$routeProvider
		.when('/clientes', {
			templateUrl: 'view/cliente.html',
			controller : "clienteController"
		})
		
		.otherwise({redirectTo:'/'});		
}]);

/**
appCliente.config(function($routeProvider){
		
	$routeProvider
	.when("/clientes",{templateUrl:'view/cliente.html', controller:'clienteController'})
	.otherwise({rediretTo:'/'});

	
	
});

*/


