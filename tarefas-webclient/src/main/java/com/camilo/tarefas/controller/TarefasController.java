package com.camilo.tarefas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.camilo.tarefas.model.Tarefa;
import com.camilo.tarefas.services.TarefasService;

@Controller
@RequestMapping("/tarefas")
public class TarefasController {
	
	@Autowired
	private TarefasService tarefasService;
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {
		return "index";
	}

	@RequestMapping(method = RequestMethod.GET)
	public ModelAndView listar() {
		ModelAndView mv = new ModelAndView("lista-tarefas");
		mv.addObject("tarefas", tarefasService.listar());
		return mv;
	}
	
	@RequestMapping(value = "/cadastro", method = RequestMethod.GET)
	public ModelAndView cadastrar(@ModelAttribute Tarefa tarefa) {
		ModelAndView mv = new ModelAndView("cadastro-tarefa");
		mv.addObject("tarefa", tarefa);
		return mv;
	}

	@RequestMapping(method = RequestMethod.POST)
	public ModelAndView salvar(Tarefa tarefa) {
		ModelAndView mv = new ModelAndView("redirect:/tarefas");
		mv.addObject("location", tarefasService.salvar(tarefa));
		return mv;
	}
}
