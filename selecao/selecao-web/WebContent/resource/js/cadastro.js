
var table;
var currentUsuario = new Object();
var userSearch = new Object();

/**
 * Funcionalidade de Persistencia usando angular.
 */
var appNovoEdit = angular.module("newEditUser", []);
appNovoEdit.controller("save", function ($scope) {
	
	$scope.salve = function(user) {
		currentUsuario = angular.copy(user);
		var id = $('input[type="hidden"][name="id-user"]').val();
		if (id.length) {
			// faz merge
			$.ajax({
				type: 'PUT',
				url: '/interactive-web/api/usuario/' + currentUsuario.id,
				data: JSON.stringify(currentUsuario),
				contentType: 'application/json',
				dataType: 'json',
				success: function(data) {
					loadSearchPage();
					$scope.user = {};
				}
			});
		} else {
			// persiste novo registro
			$.ajax({
				type: 'POST',
				url: '/interactive-web/api/usuario',
				data: JSON.stringify(currentUsuario),
				contentType: 'application/json',
				dataType: 'json',
				success: function(data) {
					loadSearchPage();
					$scope.user = {};
				}
			});
		}
	};
	$scope.cancelar = function () {
		// volta para pagina de pesquisa
		cancelEdit();
	};
});

/**
 * Funcionalidade de pesquisa usando angular.
 */
var appSearch = angular.module("searchUser", []);
appSearch.controller("search", function($scope) {
	
	$scope.newUser = function() {
		loadNewEditPage();
	};
	
	$scope.search = function() {
		userSearch = $scope.user;
		setDatatableSearch();
	};
	
	// executa a pesquisa
	$scope.search();
	
});

/**
 * Seta o datatable dos itens de pesquisa.
 */
function setDatatableSearch() {
	if ( $.fn.dataTable.isDataTable( '#dt-search-usuarios' ) ) {
		table = $('#dt-search-usuarios').DataTable();
	    table.destroy();
	}
	table = $('#dt-search-usuarios').DataTable({
		language: {
            url: "/interactive-web/resources/js/dataTables-i18n-ptbr.json"
        },
        pageLength : 10,
        lengthChange : false, 
		searching : false,
	    ordering : false,
		processing : true,
		serverSide : true,
		rowId: "id",
		ajax : {
			url : "/interactive-web/api/usuario?" + $.param(userSearch),
			contentType : "application/json",
		},
		columns : [
		   { data : "nome" },
		   { data : "cpfCnpj" },
		   { data : "id", width : "80px", sClass: 'align-center',
			 render : function (data, type, full, meta) {
				 return '<a class="view-register btn btn-default btn-xs" data-id="' 
				 + data + '" href="javascript:void(0)">Editar</a>'; 
			 }
		   },
		   { data : "id", width : "80px", sClass: 'align-center',
			 render : function (data, type, full, meta) {
				 return '<a class="delete-register btn btn-xs btn-default" data-id="' 
				 + data + '" href="javascript:void(0)">Excluir</a>'; 
			 }
		   }
		]
	});
}

/**
 * Chamado ao carrega a pagina com o script.
 */
function loadPage() {
	loadSearchPage();
	
	userSearch = {};
	
	setDatatableSearch();
	
	$('#dt-search-usuarios').on('click', 'a.view-register', function() {
		editUsuario($(this).data('id'));
	});
	
	$('#dt-search-usuarios').on('click', 'a.delete-register', function() {
		deleteUsuario($(this).data('id'));
	});
	
}

/**
 * Carrega a pagina de pesquisa.
 */
function loadSearchPage() {
	$('#edit-new-container').hide();
	//$('#edit-new-container').show();
	$('#search-container').show();
}

/**
 * Deleta um usuario conforme o ID.
 * @param id
 */
function deleteUsuario(id) {
	// poderia usar um dialog do bootstrap, mas o tempo foi curto.
	$.ajax({
		type : 'DELETE',
		dataType: 'json',
		url : "/interactive-web/api/usuario/" + id,
		success: function(data) {
			setDatatableSearch();
		},
	});
}

/**
 * Editar o usuario conforme o ID.
 * @param id
 */
function editUsuario(id) {
	$.ajax({
		type : 'GET',
		dataType: 'json',
		url : "/interactive-web/api/usuario/" + id,
		success: function(data) {
			loadNewEditPage();
			$('input[type="hidden"][name="id-user"]').val(data.id);
			$('input[name="nome"]').val(data.nome);
			
			$('#lbl-title').val('Editar ');
			
			$('input[name="cpfCnpj"]').val(data.cpfCnpj);
		},
	});
	
}

/**
 * Carrega a pagina de edicao/novo registro.
 */
function loadNewEditPage() {
	$('#edit-new-container').show();
	$('#search-container').hide();
}

/**
 * Limpa o formul�rio de edicao.
 */
function cleanFieldsEdit() {
	$('input[type="hidden"][name="id-user"]').val('');
	$('input[name="nome"]').val('');
	$('input[name="cpfCnpj"]').val('');
}

/**
 * Cancela uma edicao de um registro e volta para a pagina de pesquisa.
 */
function cancelEdit() {
	cleanFieldsEdit();
	loadSearchPage();
}

