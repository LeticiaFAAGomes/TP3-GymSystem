package br.edu.infnet.GymSystem.config;

import br.edu.infnet.GymSystem.models.Instrutor;
import br.edu.infnet.GymSystem.models.Plano;
import br.edu.infnet.GymSystem.repositories.InstrutorRepository;
import br.edu.infnet.GymSystem.repositories.PlanoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private PlanoRepository planoRepository;

    @Autowired
    private InstrutorRepository instrutorRepository;

    @Override
    public void run(String... args) {

        planoRepository.save(
                new Plano(null,"Executivo",99.90)
        );

        planoRepository.save(
                new Plano(null,"Anual",150.00)
        );

        Instrutor instrutor1 = new Instrutor();
        instrutor1.setNome("Laura");
        instrutor1.setCREF("12345");

        instrutorRepository.save(instrutor1);

        Instrutor instrutor2 = new Instrutor();
        instrutor2.setNome("Joana");
        instrutor2.setCREF("67890");

        instrutorRepository.save(instrutor2);
    }
}