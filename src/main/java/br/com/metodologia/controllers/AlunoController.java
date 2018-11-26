package br.com.metodologia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.metodologia.models.Aluno;
import br.com.metodologia.repositories.AlunoRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository ar;
	
	@RequestMapping("/aluno")
	public ModelAndView listaAlunos() {
		ModelAndView mv = new ModelAndView("cadAluno");
		Iterable<Aluno> alunos = ar.findAll();
		mv.addObject("alunos", alunos);
		return mv;
	}
	
	@RequestMapping(value="/aluno", method=RequestMethod.POST)
	public String cadastrarAluno(@Valid Aluno aluno , BindingResult result, RedirectAttributes attributes) {
		if(result.hasErrors()) {
			attributes.addFlashAttribute("mensagem", "Verifique os campos");
			return "redirect:/aluno";
		}
		ar.save(aluno);
		attributes.addFlashAttribute("mensagem", "Aluno adicionado com sucesso");
		return "redirect:/aluno";
	}
	
	@RequestMapping("/deleteA")
	public String deletarAluno(long id) {
		Aluno aluno = ar.findById(id);
		ar.delete(aluno);
		return "redirect:/aluno";
	}
	
	
	
	
}
