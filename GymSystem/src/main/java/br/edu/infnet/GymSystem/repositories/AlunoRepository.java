package br.edu.infnet.GymSystem.repositories;

import br.edu.infnet.GymSystem.models.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
