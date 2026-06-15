package br.edu.infnet.GymSystem.repositories;

import br.edu.infnet.GymSystem.models.Treino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlanoRepository extends JpaRepository<Treino, Long> {
}
