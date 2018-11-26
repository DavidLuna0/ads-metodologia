package br.com.metodologia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import br.com.metodologia.models.Professor;
import br.com.metodologia.repositories.ProfessorRepository;

@Controller
public class ProfessorController {
	
	@Autowired
	private ProfessorRepository pr;
	
	@RequestMapping(value="/professor", method=RequestMethod.GET)
	public String professor() {
		return "cadProfessor";
	}
	
	@RequestMapping(value="/professor", method=RequestMethod.POST)
	public String cadastrarAluno(Professor professor) {
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
}
