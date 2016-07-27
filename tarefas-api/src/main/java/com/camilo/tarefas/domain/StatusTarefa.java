package com.camilo.tarefas.domain;

public enum StatusTarefa {

	PENDENTE ("pendente"),
	INICIADA ("iniciada"),
	CONCLUIDA("concluída"),
	CANCELADA("cancelada");
	
	private String descricao;
	
	StatusTarefa(String descricao)
	{
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
