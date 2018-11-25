package br.com.metodologia.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ProfessorController {

	@RequestMapping("/professor")
	public String aluno() {
		return "cadProfessor";
	}
}
