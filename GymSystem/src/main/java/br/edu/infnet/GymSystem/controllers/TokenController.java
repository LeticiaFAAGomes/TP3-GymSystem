package br.edu.infnet.GymSystem.controllers;

import br.edu.infnet.GymSystem.services.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tokens")
public class TokenController {

    @Autowired
    private TokenService service;

    @PostMapping("/{alunoId}")
    public String gerarToken(@PathVariable Long alunoId){
        return service.gerarToken(alunoId);
    }

    @GetMapping("/{token}")
    public boolean validarToken(@PathVariable String token){
        return service.validarToken(token);
    }
}