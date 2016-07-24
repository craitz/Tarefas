package com.camilo.tarefas.services;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.camilo.tarefas.domain.StatusTarefa;
import com.camilo.tarefas.domain.Tarefa;
import com.camilo.tarefas.repositories.TarefasRepository;
import com.camilo.tarefas.services.exceptions.TarefaJaExisteException;
import com.camilo.tarefas.services.exceptions.TarefaNaoEncontradaException;

@Service
public class TarefasService {

	@Autowired
	private TarefasRepository tarefasRepository;
	
	public Tarefa salvar(Tarefa tarefa) {		
		//testa se foi passado algum id na criação do objeto
		if (tarefa.getId() != null) {
			//testa se esse id que foi passado já existe
			if (buscar(tarefa.getId(), false) != null) {
				throw new TarefaJaExisteException();
			}
		}

		tarefa.setDataCadastro(new Date());
		tarefa.setStatus(StatusTarefa.PARADA);

		return tarefasRepository.save(tarefa);
	}

	public List<Tarefa> listar() {
		return tarefasRepository.findAll();
	}

	public Tarefa buscar(Long id, Boolean lancaExcecao) {		
		Tarefa tarefa = tarefasRepository.findOne(id);
		if ( (tarefa == null) && (lancaExcecao) ) {
			throw new TarefaNaoEncontradaException();
		}
		
		return tarefa;
	}
	
	public void atualizar(Long id, Tarefa tarefa) {		
		buscar(id, true);

		//garante que o objeto vai ser atualizado e não criado
		tarefa.setId(id);

		tarefasRepository.save(tarefa);
	}

	public void deletar(Long id) {
		tarefasRepository.delete(buscar(id, true));
	}
}
