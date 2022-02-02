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

import com.demomvc.curso.boot.domain.Marca;
import com.demomvc.curso.boot.service.MarcaService;




@Controller
@RequestMapping("/marcas") // Mapeia URL padrao
public class MarcaController {

	@Autowired // Injeção de dependencia
	private MarcaService service;

	@GetMapping("/cadastrar")
	public String cadastrar(Marca marca) {
		return "/marca/cadastro";
	}

	@PostMapping("/salvar")
	public String salvar(@Valid Marca marca, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "marca/cadastro";
		}

		service.salvar(marca);
		// Mensagem adicionada para exibir o resultado da transaÃ§Ã£o cadastrar
		attr.addFlashAttribute("success", "Marca " + marca.getNome() + " inserido com sucesso.");
		return "redirect:/marcas/cadastrar";
	}

	@GetMapping("/listar")
	public String listar(ModelMap model) {
		model.addAttribute("marcas", service.buscarTodos());
		return "/marca/lista";
	}

	@GetMapping("/editar/{id}")
	public String preEditar(@PathVariable("id") Long id, ModelMap model) {
		model.addAttribute("marca", service.buscarPorId(id));
		return "/marca/cadastro";
	}

	@PostMapping("/editar")
	public String editar(@Valid Marca marca, BindingResult result, RedirectAttributes attr) {

		if (result.hasErrors()) {
			return "marca/cadastro";
		}

		service.editar(marca);
		// Mensagem adicionada para exibir o resultado da transação editar
		attr.addFlashAttribute("success", "Marca " + marca.getNome() + " editado com sucesso.");
		return "redirect:/marcas/cadastrar";
	}

	@GetMapping("/excluir/{id}")
	public String excluir(@PathVariable("id") Long id, ModelMap model) {
		service.excluir(id);
		// Mensagem adicionada para exibir o resultado da transaçãoo excluir
		model.addAttribute("success", "Marca removido com sucesso.");
		return listar(model);
	}
}
