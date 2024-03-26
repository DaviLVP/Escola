package com.davi.escola.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Disciplina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Column(unique = true)
    String nome;

    @OneToOne
    @JoinColumn(name = "professor_id")
    Professor professor;

    @ManyToMany
    @JoinTable(name = "DISCIPLINA_ALUNO",
            joinColumns = @JoinColumn(name = "ID_DISCIPLINA"),
            inverseJoinColumns = @JoinColumn(name = "ID_ALUNO"))
    List<Aluno> alunos;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public List<Aluno> getAlunos() {
        return alunos;
    }

    public void setAlunos(List<Aluno> alunos) {
        this.alunos = alunos;
    }
}

