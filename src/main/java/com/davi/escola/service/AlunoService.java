package com.davi.escola.service;

import com.davi.escola.model.Aluno;
import com.davi.escola.repository.AlunoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class AlunoService {
    private final AlunoRepository repository;
    public Aluno create(Aluno entity) {

        log.info("Aluno no service: " + entity.getId());
        log.info("Aluno no service: " + entity.getNome());
        log.info("Aluno no service: " + entity.getTurma());
        log.info("Aluno no service: " + entity.getDataMatricula().toString());

        Aluno alunoSalvoNoBanco = repository.save(entity);

        log.info("Aluno no depois de salvar no banco: " + entity.getId());
        log.info("Aluno no depois de salvar no banco: " + entity.getNome());
        log.info("Aluno no depois de salvar no banco: " + entity.getTurma());
        log.info("Aluno no depois de salvar no banco: " + entity.getDataMatricula().toString());

        return entity;

    }
}
