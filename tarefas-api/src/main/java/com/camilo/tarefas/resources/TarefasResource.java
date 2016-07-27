package com.camilo.tarefas.resources;

import java.net.URI;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.camilo.tarefas.domain.Tarefa;
import com.camilo.tarefas.services.TarefasService;

@RestController
@RequestMapping("/tarefas")
public class TarefasResource {

	@Autowired
	private TarefasService tarefasService;

	@CrossOrigin
	@RequestMapping(method = RequestMethod.POST)
	public ResponseEntity<Void> salvar(@Valid @RequestBody Tarefa tarefa) {
		tarefa = tarefasService.salvar(tarefa);
		
		//monta a uri com a localização do objeto salvo
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(tarefa.getId()).toUri();
		
		//retorna a uri
		return ResponseEntity.created(uri).build();
	}

	@CrossOrigin
	@RequestMapping(method = RequestMethod.GET)
	public ResponseEntity<List<Tarefa>> listar() {
		return ResponseEntity.status(HttpStatus.OK).body(tarefasService.listar());
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ResponseEntity<Tarefa> buscar(@PathVariable("id") Long id) {
		return ResponseEntity.status(HttpStatus.OK).body(tarefasService.buscar(id, true));
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.PUT)
	public ResponseEntity<Void> atualizar(@Valid @PathVariable("id") Long id, @RequestBody Tarefa tarefa) {
		tarefasService.atualizar(id, tarefa);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deletar(@PathVariable("id") Long id) {
		tarefasService.deletar(id);
		return ResponseEntity.noContent().build();
	}
	
	@CrossOrigin
	@RequestMapping(value = "/{id}/finalizacao", method = RequestMethod.PUT)
	public ResponseEntity<Void> concluir(@PathVariable("id") Long id) {
		tarefasService.concluir(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}/abertura", method = RequestMethod.PUT)
	public ResponseEntity<Void> iniciar(@PathVariable("id") Long id) {
		tarefasService.iniciar(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}/reset", method = RequestMethod.PUT)
	public ResponseEntity<Void> pender(@PathVariable("id") Long id) {
		tarefasService.pender(id);
		return ResponseEntity.noContent().build();
	}

	@CrossOrigin
	@RequestMapping(value = "/{id}/cancelamento", method = RequestMethod.PUT)
	public ResponseEntity<Void> cancelar(@PathVariable("id") Long id) {
		tarefasService.cancelar(id);
		return ResponseEntity.noContent().build();
	}
}
