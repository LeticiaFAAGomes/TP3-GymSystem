package br.edu.infnet.GymSystem.repositories;

import br.edu.infnet.GymSystem.documents.AvaliacaoFisica;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AvaliacaoFisicaRepository
        extends MongoRepository<AvaliacaoFisica, String> {

    List<AvaliacaoFisica> findByAlunoId(Long alunoId);
}