package com.camilo.tarefas.domain;

public enum StatusTarefa {

	PARADA   ("em espera"),
	INICIADA ("em aberto"),
	CONCLUIDA("concluída");
	
	private String descricao;
	
	StatusTarefa(String descricao)
	{
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}
}
