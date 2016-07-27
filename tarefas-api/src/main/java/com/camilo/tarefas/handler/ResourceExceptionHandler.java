package com.camilo.tarefas.handler;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.transaction.TransactionSystemException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.camilo.tarefas.domain.DetalhesErro;
import com.camilo.tarefas.services.exceptions.TarefaJaExisteException;
import com.camilo.tarefas.services.exceptions.TarefaNaoEncontradaException;

@ControllerAdvice
public class ResourceExceptionHandler {

	private static final String urlErros = "http://erros.tarefas.com";

	@ExceptionHandler(TarefaNaoEncontradaException.class)
	public ResponseEntity<DetalhesErro> handlerTarefaNaoEncontradaException 
				(TarefaNaoEncontradaException e, HttpServletRequest request) {
	
		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Tarefa não encontrada");
		erro.setStatus(404L);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor(urlErros + "/404");
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(erro);
	}

	@ExceptionHandler(TarefaJaExisteException.class)
	public ResponseEntity<DetalhesErro> handlerTarefaJaExisteException 
				(TarefaJaExisteException e, HttpServletRequest request) {
	
		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Tarefa já existente");
		erro.setStatus(409L);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor(urlErros + "/409");
		
		return ResponseEntity.status(HttpStatus.CONFLICT).body(erro);
	}
	
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<DetalhesErro> handlerHttpMessageNotReadableException
				(HttpMessageNotReadableException e, HttpServletRequest request) {
	
		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Erro de formatação na requisição");
		erro.setStatus(400L);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor(urlErros + "/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<DetalhesErro> handlerMethodArgumentNotValidException
				(MethodArgumentNotValidException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo(e.getBindingResult().getFieldError().getDefaultMessage());
		erro.setStatus(400L);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor(urlErros + "/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
	@ExceptionHandler(TransactionSystemException.class)
	public ResponseEntity<DetalhesErro> handlerTransactionSystemException
				(TransactionSystemException e, HttpServletRequest request) {
		
		DetalhesErro erro = new DetalhesErro();
		erro.setTitulo("Erro no preenchimento do campo");
		erro.setStatus(400L);
		erro.setTimestamp(System.currentTimeMillis());
		erro.setMensagemDesenvolvedor(urlErros + "/400");
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(erro);
	}
	
}

