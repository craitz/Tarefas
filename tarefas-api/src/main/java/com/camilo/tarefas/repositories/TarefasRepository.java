package com.camilo.tarefas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.camilo.tarefas.domain.Tarefa;

public interface TarefasRepository extends JpaRepository<Tarefa, Long> {

}
