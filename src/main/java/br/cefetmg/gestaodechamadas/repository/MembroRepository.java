package br.cefetmg.gestaodechamadas.repository;

import br.cefetmg.gestaodechamadas.model.Membro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembroRepository extends JpaRepository<Membro, Long> {
}