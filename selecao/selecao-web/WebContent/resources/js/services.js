/**
 * 
 */
 'use strict'

var services = angular.module('enderecoApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

services.factory('EnderecoFactory', function($resource) {
	return $resource( baseUrl + '/selecao-web/api/endereco/:id', {id:'@id'}, {
		'update' : {method: 'PUT'}
	}, null);
}).service('popupService',function($window){
    this.showPopup = function(message){
        return $window.confirm(message);
    }
});

services.factory('CepAppFactory', function($resource){
	return $resource( 'http://correiosapi.apphb.com/cep/:id', {id:'@id'}, null, null);
});