package br.edu.infnet.GymSystem.documents;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "avaliacoes")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AvaliacaoFisica {

    @Id
    private String id;

    private Long alunoId;
    private Double peso;
    private Double altura;
    private Double percentualGordura;
    private String anotacoesMedicas;
}