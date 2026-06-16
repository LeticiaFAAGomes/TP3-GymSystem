package br.edu.infnet.GymSystem.controllers;

import br.edu.infnet.GymSystem.models.Treino;
import br.edu.infnet.GymSystem.services.TreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoService service;

    @PostMapping
    public Treino cadastrar(@RequestBody Treino treino){
        return service.salvar(treino);
    }
}
