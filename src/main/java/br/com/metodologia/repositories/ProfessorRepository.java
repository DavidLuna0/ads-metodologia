package br.com.metodologia.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.metodologia.models.Professor;

public interface ProfessorRepository extends CrudRepository<Professor, String> {

	Professor findById(Long id);
	Professor findByNome(String nome);
}
