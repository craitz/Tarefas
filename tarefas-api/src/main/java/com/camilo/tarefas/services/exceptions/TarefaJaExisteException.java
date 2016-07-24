package com.camilo.tarefas.services.exceptions;

public class TarefaJaExisteException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TarefaJaExisteException() {
		super();
	}

	public TarefaJaExisteException(String mensagem) {
		super(mensagem);
	}
	
	public TarefaJaExisteException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}	
}
