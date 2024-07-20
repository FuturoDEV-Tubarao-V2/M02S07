package org.senai.labsenai.services;

import org.senai.labsenai.models.Turma;
import org.senai.labsenai.repositories.TurmaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TurmaService {

    @Autowired
    TurmaRepository turmaRepository;

    public Turma saveTurma(Turma turma){
        return turmaRepository.save(turma);
    }

}
