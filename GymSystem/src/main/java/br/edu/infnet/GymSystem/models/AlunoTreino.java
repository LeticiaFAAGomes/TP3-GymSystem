package br.edu.infnet.GymSystem.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class AlunoTreino {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Aluno aluno;

    @ManyToOne
    private Treino treino;

    private LocalDate dataInicio;

    private Boolean ehConcluido;
}