package br.edu.infnet.GymSystem.models;

import jakarta.persistence.*;

@Entity
public class Treino {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nomeTreino;
    private String focoPrincipal;

    @ManyToOne
    @JoinColumn(name = "instrutor_id")
    private Instrutor instrutor;
}
