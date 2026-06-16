package br.edu.infnet.GymSystem.controllers;

import br.edu.infnet.GymSystem.documents.AvaliacaoFisica;
import br.edu.infnet.GymSystem.services.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService service;

    @PostMapping
    public AvaliacaoFisica cadastrar(@RequestBody AvaliacaoFisica avaliacao) {
        return service.salvar(avaliacao);
    }

    @GetMapping("/aluno/{id}")
    public List<AvaliacaoFisica> listarPorAluno(@PathVariable Long id) {
        return service.buscarPorAluno(id);
    }
}