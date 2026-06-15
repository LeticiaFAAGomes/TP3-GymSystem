package br.edu.infnet.GymSystem.models;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String email;
    private LocalDate dataNascimento;
    private Boolean ehAtivo;

    @ManyToOne
    @JoinColumn(name = "plano_id")
    private Plano plano;
}
