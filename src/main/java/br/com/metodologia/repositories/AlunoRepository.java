package br.com.metodologia.repositories;

import org.springframework.data.repository.CrudRepository;

import br.com.metodologia.models.Aluno;

public interface AlunoRepository extends CrudRepository<Aluno, String> {

	Aluno findById(Long id);
	Aluno findByNome(String nome);
}
