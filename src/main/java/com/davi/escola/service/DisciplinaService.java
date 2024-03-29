package com.davi.escola.service;

import com.davi.escola.dto.RequestMatricula;
import com.davi.escola.model.Aluno;
import com.davi.escola.model.Disciplina;
import com.davi.escola.model.Professor;
import com.davi.escola.repository.AlunoRepository;
import com.davi.escola.repository.ProfessorRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import com.davi.escola.repository.DisciplinaRepository;
@Slf4j
@Service
@AllArgsConstructor
public class DisciplinaService {
    private DisciplinaRepository disciplinaRepository;
    private AlunoRepository alunoRepository;
    private ProfessorRepository professorRepository;

    public Disciplina create(Disciplina requisicaoUsuario) {
        Professor professorBancoDados = professorRepository.findByNome(requisicaoUsuario.getProfessor().getNome());
        requisicaoUsuario.setProfessor(professorBancoDados);
        return disciplinaRepository.save(requisicaoUsuario);
    }

    public Disciplina matricular(RequestMatricula request){
        log.info("requisição está na classe service "+ request.getNomeDisciplina());
        log.info("requisição está na classe service "+ request.getNomeAluno());

        Disciplina disciplinaDoBanco = disciplinaRepository.findByNome(request.getNomeDisciplina());
        Aluno alunoDoBanco = alunoRepository.findByNome(request.getNomeAluno());


        log.info("requisição está na classe service - Aluno do Banco "+ alunoDoBanco.getId());
        log.info("requisição está na classe service - Aluno do Banco "+ alunoDoBanco.getNome());

        log.info("requisição está na classe service - Disciplina do Banco "+ disciplinaDoBanco.getId());
        log.info("requisição está na classe service - Disciplina do Banco "+ disciplinaDoBanco.getNome());

        disciplinaDoBanco.getAlunos().add(alunoDoBanco);
        Disciplina disciplinaAtualizada = disciplinaRepository.save(disciplinaDoBanco);

        return disciplinaAtualizada;
    }
}