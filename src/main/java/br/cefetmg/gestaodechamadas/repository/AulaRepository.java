package br.cefetmg.gestaodechamadas.repository;

import br.cefetmg.gestaodechamadas.model.Aula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AulaRepository extends JpaRepository<Aula, Long> {
}
