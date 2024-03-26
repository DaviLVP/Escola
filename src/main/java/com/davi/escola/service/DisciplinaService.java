package com.davi.escola.service;

import com.davi.escola.model.Disciplina;
import com.davi.escola.model.Professor;
import com.davi.escola.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.davi.escola.repository.DisciplinaRepository;

@Service
@AllArgsConstructor
public class DisciplinaService {
    private DisciplinaRepository repository;
    private ProfessorRepository professorRepository;

    public Disciplina create(Disciplina requisicaoUsuario) {
        Professor professorBancoDados = professorRepository.findByNome(requisicaoUsuario.getProfessor().getNome());
        requisicaoUsuario.setProfessor(professorBancoDados);
        return repository.save(requisicaoUsuario);
    }
}