package com.camilo.tarefas.services.exceptions;

public class TarefaNaoEncontradaException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public TarefaNaoEncontradaException() {
		super();
	}

	public TarefaNaoEncontradaException(String mensagem) {
		super(mensagem);
	}
	
	public TarefaNaoEncontradaException(String mensagem, Throwable causa) {
		super(mensagem, causa);
	}	
}
