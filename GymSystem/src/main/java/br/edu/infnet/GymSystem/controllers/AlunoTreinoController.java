package br.edu.infnet.GymSystem.controllers;

import br.edu.infnet.GymSystem.services.AlunoTreinoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/ranking")
public class AlunoTreinoController {

    @Autowired
    private AlunoTreinoService service;

    @GetMapping
    public List<Object[]> ranking(){
        return service.ranking();
    }
}
