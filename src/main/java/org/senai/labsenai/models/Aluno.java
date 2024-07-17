package org.senai.labsenai.models;

import jakarta.persistence.*;

import java.util.Date;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;

    @Column(nullable = false)
    private String nome;

    @Temporal(TemporalType.DATE)
    private Date dt_nascimento;

    @Column(length = 11, nullable = false)
    private String telefone;
}
