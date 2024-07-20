package org.senai.labsenai.repositories;

import org.senai.labsenai.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

   Optional<Aluno> findByCpf(String cpf);

   @Query("SELECT al FROM Aluno al WHERE turma IS NOT NULL")
   List<Aluno> findByAlunos();
}
