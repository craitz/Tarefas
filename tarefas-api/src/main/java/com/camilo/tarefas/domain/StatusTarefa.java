package com.camilo.tarefas.domain;

public enum StatusTarefa {

	PARADA("Parada"),
	INICIADA("Iniciada"),
	CONCLUIDA("Concluída");
	
	private String descricao;
	
	StatusTarefa(String descricao)
	{
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
