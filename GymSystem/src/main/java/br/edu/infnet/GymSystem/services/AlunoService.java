package br.edu.infnet.GymSystem.services;

import br.edu.infnet.GymSystem.models.Aluno;
import br.edu.infnet.GymSystem.repositories.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository repository;

    public Aluno salvar(Aluno aluno){
        return repository.save(aluno);
    }

    public List<Aluno> listarAtivos(){
        return repository.findByEhAtivoTrue();
    }
}