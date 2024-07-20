package org.senai.labsenai.controllers;

import org.senai.labsenai.models.Turma;
import org.senai.labsenai.services.TurmaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/turma")
public class TurmaController {

    @Autowired
    TurmaService turmaService;

    @PostMapping
    public ResponseEntity<Turma> saveTurma(@RequestBody Turma turma){
        return ResponseEntity.status(HttpStatus.CREATED).body(turmaService.saveTurma(turma));
    }
}
