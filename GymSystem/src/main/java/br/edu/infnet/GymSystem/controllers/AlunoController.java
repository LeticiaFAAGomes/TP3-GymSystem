package br.edu.infnet.GymSystem.controllers;

import br.edu.infnet.GymSystem.models.Aluno;
import br.edu.infnet.GymSystem.services.AlunoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoService service;

    @PostMapping
    public Aluno cadastrar(@RequestBody Aluno aluno){
        return service.salvar(aluno);
    }

    @GetMapping("/ativos")
    public List<Aluno> listarAtivos(){
        return service.listarAtivos();
    }
}
