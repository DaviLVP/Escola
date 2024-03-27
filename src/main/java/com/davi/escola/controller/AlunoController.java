package com.davi.escola.controller;
import com.davi.escola.model.Aluno;
import com.davi.escola.model.Disciplina;
import com.davi.escola.model.Professor;
import com.davi.escola.service.AlunoService;
import com.davi.escola.service.DisciplinaService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davi.escola.service.ProfessorService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/alunos")
@Slf4j
public class AlunoController {
    private final AlunoService service;


    @PostMapping
    public ResponseEntity<Aluno> create(@RequestBody Aluno entity) {

        log.info("Aluno no controller: " + entity.getId());
        log.info("Aluno no controller: " + entity.getNome());
        log.info("Aluno no controller: " + entity.getTurma());
        log.info("Aluno no controller: " + entity.getDataMatricula().toString());

        Aluno alunoQueRetornouDoService = service.create(entity);

        log.info("Aluno retornado controller: " + alunoQueRetornouDoService.getId());
        log.info("Aluno retornado controller: " + alunoQueRetornouDoService.getNome());
        log.info("Aluno retornado controller: " + alunoQueRetornouDoService.getTurma());
        log.info("Aluno retornado controller: " + alunoQueRetornouDoService.getDataMatricula().toString());

        return ResponseEntity.ok(alunoQueRetornouDoService);
    }
}

