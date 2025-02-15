package br.cefetmg.gestaodechamadas.service;

import br.cefetmg.gestaodechamadas.model.Aula;
import br.cefetmg.gestaodechamadas.repository.AulaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AulaService {

    private final AulaRepository aulaRepository;

    public Aula getById(Long id) {
        return aulaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Aula não encontrada"));
    }

    public Aula create(Aula aula) {
        if (aula.getIdAula() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }
        return aulaRepository.save(aula);
    }

    public List<Aula> getAll() {
        return aulaRepository.findAll();
    }

    public Aula update(Aula aula) {
        if (aula.getIdAula() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }
        return aulaRepository.save(aula);
    }

    public Aula delete(Long id) {
        Aula aula = getById(id);
        aulaRepository.delete(aula);
        return aula;
    }
}