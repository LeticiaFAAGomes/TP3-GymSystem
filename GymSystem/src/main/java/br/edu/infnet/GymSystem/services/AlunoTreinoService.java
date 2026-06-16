package br.edu.infnet.GymSystem.services;

import br.edu.infnet.GymSystem.repositories.AlunoTreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoTreinoService {

    @Autowired
    private AlunoTreinoRepository repository;

    public List<Object[]> ranking(){
        return repository.ranking();
    }
}
