package com.davi.escola.controller;

import com.davi.escola.model.Professor;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.davi.escola.service.ProfessorService;

@RestController
@AllArgsConstructor
@RequestMapping("/professores")
public class ProfessorController {
    private ProfessorService service;

    @PostMapping
    public ResponseEntity<Professor> create(@RequestBody Professor entity) {
        return ResponseEntity.ok(service.create(entity));
    }
}
