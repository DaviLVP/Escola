package com.davi.escola.service;

import com.davi.escola.model.Professor;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.davi.escola.repository.DisciplinaRepository;
import com.davi.escola.repository.ProfessorRepository;

@Service
@AllArgsConstructor
public class ProfessorService {
    private ProfessorRepository repository;
    private DisciplinaRepository disciplinaRepository;

    public Professor create(Professor entity) {

        return repository.save(entity);
    }
}
