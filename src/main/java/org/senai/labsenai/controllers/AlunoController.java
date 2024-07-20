package org.senai.labsenai.controllers;

import org.apache.coyote.Response;
import org.senai.labsenai.models.Aluno;
import org.senai.labsenai.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/aluno")
public class AlunoController {

    @Autowired
    AlunoService alunoService;

    @PostMapping
    public ResponseEntity<Object> saveAluno(@RequestBody Aluno aluno){

        Optional<Aluno> optionalAluno = alunoService.findByCpf(aluno.getCpf());

        if(optionalAluno.isPresent()){
            return ResponseEntity.status(HttpStatus.CONFLICT).body("CPF já cadastrado no Banco de Dados!");
        }

        return ResponseEntity.status(HttpStatus.CREATED).body(alunoService.saveAluno(aluno));
    }

    @GetMapping
    public ResponseEntity<List<Aluno>> findAllAluno(){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.findAllAluno());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findByIdAluno(@PathVariable Integer id){
        Optional<Aluno> optionalAluno = alunoService.findByIdAluno(id);

        if(!optionalAluno.isPresent()){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O aluno não foi encontrado!");
        }
        return ResponseEntity.status(HttpStatus.OK).body(optionalAluno.get());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> updateAluno(@PathVariable Integer id, @RequestBody Aluno aluno){
        return ResponseEntity.status(HttpStatus.OK).body(alunoService.updateAluno(id, aluno));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> deleteAluno(@PathVariable Integer id){
        alunoService.deleteAluno(id);
        return ResponseEntity.status(HttpStatus.OK).body("Aluno foi excluído com sucesso!");
    }

}
