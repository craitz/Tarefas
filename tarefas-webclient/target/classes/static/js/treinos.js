$(function() {
	$('[rel = "tooltip"]').tooltip();
	
//	$('.btn-cadastrar-usuario').on('click', function(event) {
//		event.preventDefault();
//				
//		var botao = $(event.currentTarget);
//		var form = botao.closest('form');
//		var action = form.data('url-base');
//		alert(action);
//
//		var response = $.ajax({
//			url: action,
//			type: 'POST'
//		});
//		
//		response.done(function(event) {
//			var codigoTitulo = buttonReceber.data('codigo');
//			$('[data-role=' + codigoTitulo + ']').html('<span class="label label-success">' + event + '</span>');
//			buttonReceber.hide();
//		});
//		
//		response.fail(function(event) {
//			console.log(event);
//			alert('Erro recebendo cobrança');
//		});
//	})
});

$('#confirmacaoModal').on('show.bs.modal', function(event) {
	var button = $(event.relatedTarget);
	var id = button.data('id');
	var nome = button.data('nome');
	var modal = $(this);
	var form = modal.find('form');
	var action = form.data('url-base');
	
	action = (!action.endsWith('/')) ? (action + '/') : action;
	
	form.attr('action', action + id);
	modal.find('.modal-body span').html('Tem certeza que deseja excluir o título <strong>' + nome + '</strong> ?');
});