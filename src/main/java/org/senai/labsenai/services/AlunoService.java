package org.senai.labsenai.services;

import org.senai.labsenai.models.Aluno;
import org.senai.labsenai.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

    @Autowired
    AlunoRepository alunoRepository;

    public Aluno saveAluno(Aluno aluno){
        return alunoRepository.save(aluno);
    }

    public List<Aluno> findAllAluno(){
        return alunoRepository.findAll();
    }

    public Optional<Aluno> findByIdAluno(Integer id){
        return alunoRepository.findById(id);
    }

    public Aluno updateAluno(Integer id, Aluno aluno){
        Aluno al = alunoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Aluno não foi encontrado!")
        );

        aluno.setMatricula(id);

        return alunoRepository.save(aluno);
    }

    public void deleteAluno(Integer id){
        Aluno al = alunoRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Aluno não foi encontrado!")
        );

        alunoRepository.delete(al);
    }

    public Optional<Aluno> findByCpf(String cpf){
        return alunoRepository.findByCpf(cpf);
    }

}
