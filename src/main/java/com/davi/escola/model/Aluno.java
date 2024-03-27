package com.davi.escola.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity

public class Aluno {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String nome;
    String turma;
    @JsonFormat (pattern= "dd-MM-yyyy")
    LocalDate dataMatricula;
    @ManyToMany(mappedBy = "alunos")
    List<Disciplina> disciplinas;
}
