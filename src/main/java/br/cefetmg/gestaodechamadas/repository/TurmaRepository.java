package br.cefetmg.gestaodechamadas.repository;

import br.cefetmg.gestaodechamadas.model.Turma;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TurmaRepository extends JpaRepository<Turma, Long> {
}
