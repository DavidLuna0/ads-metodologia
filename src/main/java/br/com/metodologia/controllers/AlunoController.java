package br.com.metodologia.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.metodologia.models.Aluno;
import br.com.metodologia.repositories.AlunoRepository;

@Controller
public class AlunoController {

	@Autowired
	private AlunoRepository ar;
	
	@RequestMapping(value="/aluno", method=RequestMethod.GET)
	public String aluno() {
		return "cadAluno";
	}
	
	@RequestMapping(value="/aluno", method=RequestMethod.POST)
	public String cadastrarAluno(Aluno aluno) {
		ar.save(aluno);
		return "redirect:/cadAluno";
	}
	
	
}
