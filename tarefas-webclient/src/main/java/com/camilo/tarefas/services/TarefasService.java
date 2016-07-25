package com.camilo.tarefas.services;

import java.net.URI;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.camilo.tarefas.model.Tarefa;

@Service
public class TarefasService {
	
	private RestTemplate restTemplate;
	
	private String URI_BASE;
	private String URN_BASE = "/tarefas";
	//private String credencial;
	
	public TarefasService() {
		init("http://localhost:8090", "", "");
	}
	
	public void init(String url, String usuario, String senha) {
		restTemplate = new RestTemplate();
		URI_BASE = url.concat(URN_BASE);
		//String credencialAux = usuario + ":" + senha;
		//credencial = "Basic " + Base64.getEncoder().encodeToString(credencialAux.getBytes());
	}
	
	public List<Tarefa> listar() {
//		RequestEntity<Void> request = RequestEntity.get(URI.create(URI_BASE)).
//				header("Authorization", credencial).build();
		
		RequestEntity<Void> request = RequestEntity.get(URI.create(URI_BASE)).build();

		ResponseEntity<Tarefa[]> response = restTemplate.exchange(request, Tarefa[].class);
	
		return Arrays.asList(response.getBody());
	}

	public String salvar(Tarefa tarefa) {
//		RequestEntity<Livro> request = RequestEntity.post(URI.create(URI_BASE)).
//				header("Authorization", credencial).body(livro);

		RequestEntity<Tarefa> request = RequestEntity.post(URI.create(URI_BASE)).body(tarefa);

		ResponseEntity<Void> response = restTemplate.exchange(request, Void.class);
	
		return response.getHeaders().getLocation().toString();
	}
}
