/**
 * 
 */
 'use strict';

var app = angular.module('enderecoApp.controllers', []);


// http://stackoverflow.com/questions/14718826/angularjs-disable-partial-caching-on-dev-machine
app.run(function ($rootScope, $templateCache) {
 	$rootScope.$on('$viewContentLoaded', function () {
    	$templateCache.removeAll();
 	});
});

app.controller('EnderecoListController', function($scope, popupService, $location, EnderecoFactory) {
	
	$scope.deleteEndereco = function(enderecoId) {
		if (popupService.showPopup('Deseja realmente excluir?')) {
			EnderecoFactory.remove({id:enderecoId});
			$scope.enderecos = EnderecoFactory.query();
		}
	};

	$scope.editEndereco = function(enderecoId) {
		$location.path('/endereco-edit/' + enderecoId);
	};

	$scope.newEndereco = function() {
		$location.path('/endereco-add');
	};
	
	$scope.enderecos = EnderecoFactory.query();

}).controller('EnderecoCreateController', function($scope, $location, EnderecoFactory){

	$scope.endereco = new EnderecoFactory();
	
	$scope.cancel = function() {
		$location.path('/enderecos');
	};

	$scope.addEndereco = function() {
		$scope.endereco.$save(function() {
			$location.path('/enderecos');
		});
	};
}).controller('EnderecoEditController', function($scope, $routeParams, $location, EnderecoFactory) {

	$scope.loadEndereco = function() {
		$scope.endereco = EnderecoFactory.get({id:$routeParams.id});
	};
	
	$scope.updateEndereco = function() {
		$scope.endereco.$update(function() {
			$location.path('/enderecos');
		});
	};
	
	$scope.cancel = function() {
		$location.path('/enderecos');
	};

	$scope.loadEndereco();
	
});