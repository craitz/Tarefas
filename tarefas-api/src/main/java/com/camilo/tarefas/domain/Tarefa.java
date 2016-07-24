package com.camilo.tarefas.domain;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.validator.constraints.NotEmpty;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Tarefa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty(message = "O campo [descrição] é obrigatório.")
	private String descricao;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataCadastro;
	
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date dataFinalizacao;
	
	private StatusTarefa status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataFinalizacao() {
		return dataFinalizacao;
	}

	public void setDataFinalizacao(Date dataFinalizacao) {
		this.dataFinalizacao = dataFinalizacao;
	}

	public StatusTarefa getStatus() {
		return status;
	}

	public void setStatus(StatusTarefa status) {
		this.status = status;
	}
}
