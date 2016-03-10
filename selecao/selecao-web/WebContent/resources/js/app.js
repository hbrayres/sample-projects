/**
 * 
 */
 'use strict';

angular.module('enderecoApp',  [
    'enderecoApp.services', 
    'enderecoApp.controllers'
    ])

.config(function($routerProvider, $httpProvider){
    $routerProvider.when('/enderecos', {templateUrl: 'pages/enderecos.html', controller: 'EnderecoListController'});
    $routerProvider.when('/endereco-add', {templateUrl: 'pages/endereco-add.html', controller: 'EnderecoCreateController'});
    $routerProvider.when('/endereco-edit', {templateUrl: 'pages/endereco-edit.html', controller: 'EnderecoEditController'});
    $routerProvider.otherwhise({redirectTo: '/enderecos'});

    /* http://stackoverflow.com/questions/17289195/angularjs-post-data-to-external-rest-api */
    $httpProvider.defaults.useXDomain = true;
    delete $httpProvider.defaults.headers.common['X-Requested-With'];
});

/*
angular.module('enderecoApp').config(function($stateProvider, $httpProvider){
    $stateProvider.state('enderecos',{
        url:'/endereco',
        templateUrl:'/pages/enderecos.html',
        controller:'EnderecoListController'
            
    }).state('newEndereco',{
        url:'/endereco/new',
        templateUrl:'/pages/endereco-add.html',
        controller:'EnderecoCreateController'
            
    }).state('editEndereco',{
        url:'/endereco/:id',
        templateUrl:'/pages/endereco-edit.html',
        controller:'EnderecoEditController'

    });
}).run(function($state) {
    
    $state.go('enderecos');
    
});
*/

