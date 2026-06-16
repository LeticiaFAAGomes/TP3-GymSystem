package br.edu.infnet.GymSystem.services;

import br.edu.infnet.GymSystem.documents.AvaliacaoFisica;
import br.edu.infnet.GymSystem.repositories.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AvaliacaoFisicaService {

    @Autowired
    private AvaliacaoFisicaRepository repository;

    public AvaliacaoFisica salvar(AvaliacaoFisica avaliacao) {
        return repository.save(avaliacao);
    }

    public List<AvaliacaoFisica> buscarPorAluno(Long alunoId) {
        return repository.findByAlunoId(alunoId);
    }
}
