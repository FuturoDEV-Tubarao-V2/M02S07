package org.senai.labsenai.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int matricula;

    @Column(nullable = false)
    private String nome;

    @Column(unique = true, nullable = false, length = 11)
    private String cpf;

    @Temporal(TemporalType.DATE)
    private Date dt_nascimento;

    @Column(length = 11, nullable = false)
    private String telefone;

    @ManyToOne
    @JoinColumn(name = "id_turma")
    private Turma turma;
}
