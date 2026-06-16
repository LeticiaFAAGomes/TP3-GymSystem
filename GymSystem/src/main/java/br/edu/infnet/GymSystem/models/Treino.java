package br.edu.infnet.GymSystem.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
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
