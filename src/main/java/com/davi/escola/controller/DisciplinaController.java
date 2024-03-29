package com.davi.escola.controller;

import com.davi.escola.dto.RequestMatricula;
import com.davi.escola.model.Disciplina;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davi.escola.service.DisciplinaService;

@RestController
@AllArgsConstructor
@RequestMapping("/disciplinas")
@Slf4j
public class DisciplinaController {
    private DisciplinaService service;

    @PostMapping
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina requisicaoUsuario) {
        Disciplina retornoDisciplina = service.create(requisicaoUsuario);
        return ResponseEntity.ok(retornoDisciplina);
    }

    @PostMapping("/matricular")
    public ResponseEntity<Disciplina> matricular(@RequestBody RequestMatricula request) {
        log.info("requisição está na classe controller"+ request.getNomeDisciplina());
        log.info("requisição está na classe controller"+ request.getNomeAluno());

        Disciplina disciplinaAtualizada = service.matricular(request);
        return ResponseEntity.ok(disciplinaAtualizada);

    }
}