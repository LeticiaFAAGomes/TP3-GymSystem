package br.edu.infnet.GymSystem.services;

import br.edu.infnet.GymSystem.models.Treino;
import br.edu.infnet.GymSystem.repositories.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TreinoService {

    @Autowired
    private TreinoRepository repository;

    public Treino salvar(Treino treino){
        return repository.save(treino);
    }
}