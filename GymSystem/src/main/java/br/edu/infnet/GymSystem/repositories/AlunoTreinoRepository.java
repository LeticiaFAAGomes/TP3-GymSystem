package br.edu.infnet.GymSystem.repositories;

import br.edu.infnet.GymSystem.models.AlunoTreino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AlunoTreinoRepository extends JpaRepository<AlunoTreino, Long> {

    @Query("""
        SELECT at.aluno.nome,
               COUNT(at.id)
        FROM AlunoTreino at
        WHERE at.ehConcluido = true
        GROUP BY at.aluno.nome
        ORDER BY COUNT(at.id) DESC
    """)
    List<Object[]> ranking();
}
