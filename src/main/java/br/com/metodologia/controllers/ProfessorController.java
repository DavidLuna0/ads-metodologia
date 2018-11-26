package br.com.metodologia.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.metodologia.models.Professor;
import br.com.metodologia.repositories.ProfessorRepository;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository pr;
	
	@RequestMapping(value="/professor", method=RequestMethod.POST)
	public String cadastrarAluno(@Valid Professor professor , BindingResult result, RedirectAttributes attributes) {
		pr.save(professor);
		return "redirect:/professor";
	}
	
	@RequestMapping("/professor")
	public ModelAndView listaAlunos() {
		ModelAndView mv = new ModelAndView("cadProfessor");
		Iterable<Professor> professores = pr.findAll();
		mv.addObject("professores", professores);
		return mv;
	}
	
	@RequestMapping("/deleteP")
	public String deletarProfessor(long id) {
		Professor professor = pr.findById(id);
		pr.delete(professor);
		return "redirect:/professor";
	}
}
