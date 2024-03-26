package com.davi.escola.controller;

import com.davi.escola.model.Disciplina;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davi.escola.service.DisciplinaService;

@RestController
@AllArgsConstructor
@RequestMapping("/disciplinas")
public class DisciplinaController {
    private DisciplinaService service;

    @PostMapping
    public ResponseEntity<Disciplina> create(@RequestBody Disciplina requisicaoUsuario) {
        Disciplina retornoDisciplina = service.create(requisicaoUsuario);
        return ResponseEntity.ok(retornoDisciplina);
    }
}