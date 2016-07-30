angular.module("tarefas", ["ngMessages"]);
angular.module("tarefas").controller("tarefasCtrl", function($scope, $http, $sce) {

	//carrega tarefas do back-end (API)
	var carregarTarefas = function() {
		$http.get("http://localhost:8090/tarefas").success(function(data, status) {
			$scope.tarefas = data;		
			$scope.totalTarefas = $scope.tarefas.length;
		});
};	

	carregarTarefas();

	//preferências de ordenação da lista de tarefas
	$scope.ordenarPor = function(campo) {
		$scope.criterioDeOrdenacao = campo;
		$scope.direcaoDaOrdenacao = !$scope.direcaoDaOrdenacao;
	};	

	//carrega a data atual
	$scope.now = function() {
		return new Date();
	};	

	//toggle na visibilidade da linha de nova tarefa
	$scope.novaTarefa = false;	
	$scope.setNovaTarefa = function() {
		$scope.novaTarefa = !$scope.novaTarefa;
	};

	//toggle das checkboxes de todas as tarefas
	$scope.selecionaTodos = false;	
	$scope.selecionarTodos = function() {
		$scope.selecionaTodos = !$scope.selecionaTodos;
  		angular.forEach($scope.tarefas, function (tarefa) {
      	tarefa.selecionada = $scope.selecionaTodos;
  		});			
  	};

  	$scope.finalizar = function(id) {
  		var url = "http://localhost:8090/tarefas/" + id + "/finalizacao"; 
		$http.put(url).success(function() {
			carregarTarefas();
		});
  	}

  	$scope.resetar = function(id) {
  		var url = "http://localhost:8090/tarefas/" + id + "/reset"; 
		$http.put(url).success(function() {
			carregarTarefas();
		});
  	}

  	$scope.iniciar = function(id) {
  		var url = "http://localhost:8090/tarefas/" + id + "/abertura"; 
		$http.put(url).success(function() {
			carregarTarefas();
		});
  	}

  	$scope.adicionar = function(tarefa) {
		$http.post("http://localhost:8090/tarefas", tarefa).success(function() {
			delete $scope.tarefa;
			carregarTarefas();
		});
  	}

  	$scope.deletar = function() {
  		angular.forEach($scope.tarefas, function (tarefa) {
  			if (tarefa.selecionada) {
        		var url = "http://localhost:8090/tarefas/" + tarefa.id; 
				$http.delete(url).success(function() {
					
				});
  			};
  		});
		
  	};

  	$scope.htmlTest = $sce.trustAsHtml("<b>Eu sou fodão</b>");	

  	$scope.contatoNovo = {};
});
