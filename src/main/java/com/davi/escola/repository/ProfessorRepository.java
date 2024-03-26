package com.davi.escola.repository;

import com.davi.escola.model.Disciplina;
import com.davi.escola.model.Professor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProfessorRepository extends JpaRepository<Professor, Long> {
    Professor findByNome(String nome);
}
