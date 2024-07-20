package org.senai.labsenai.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_turma;

    @Column(nullable = false)
    private String sigla;

    @Column(nullable = false)
    private String nome;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "turma")
    private List<Aluno> alunos;

}
