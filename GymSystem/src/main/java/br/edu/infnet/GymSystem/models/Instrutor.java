package br.edu.infnet.GymSystem.models;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class Instrutor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String CREF;

    @OneToMany(mappedBy = "instrutor")
    private List<Treino> treinos;

}
