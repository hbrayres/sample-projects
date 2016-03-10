/**
 * 
 */
 'use strict'

var services = angular.module('enderecoApp.services', ['ngResource']);

var baseUrl = 'http://localhost\\:8080';

services.factory('EnderecoFactory', function($resource) {
	return $resource( baseUrl + '/selecao-web/api/endereco/:id', {id:'@id'}, {
		'update' : {method: 'PUT'}
	});
}).service('popupService',function($window){
    this.showPopup = function(message){
        return $window.confirm(message);
    }
});