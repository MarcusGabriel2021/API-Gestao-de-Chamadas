package br.cefetmg.gestaodechamadas.repository;

import br.cefetmg.gestaodechamadas.model.Presenca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PresencaRepository extends JpaRepository<Presenca, Long> {
}