package com.demomvc.curso.boot.web.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.demomvc.curso.boot.domain.Cliente;
import com.demomvc.curso.boot.service.ClienteService;

@Controller
@RequestMapping("/clientes")
public class ClienteController {

	@Autowired // Injeção de dependencia
	private ClienteService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Cliente cliente) {
		return "/cliente/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "cliente/cadastro";
		}

		service.salvar(cliente);
		// Mensagem adicionada para exibir o resultado da transaÃ§Ã£o cadastrar
		attr.addFlashAttribute("success", "Cliente " + cliente.getNome() + " inserido com sucesso.");
		return "redirect:/clientes/cadastrar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("clientes", service.buscarTodos());
		return "/cliente/lista";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("cliente", service.buscarPorId(id));
		return "/cliente/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Cliente cliente, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "cliente/cadastro";
		}

		service.editar(cliente);
		// Mensagem adicionada para exibir o resultado da transação editar
		attr.addFlashAttribute("success", "Cliente " + cliente.getNome() + " editado com sucesso.");
		return "redirect:/clientes/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		// Mensagem adicionada para exibir o resultado da transaçãoo excluir
		model.addAttribute("success", "Cliente removido com sucesso.");
		return listar(model);
	}
}

	

