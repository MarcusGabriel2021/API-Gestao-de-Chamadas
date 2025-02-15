package br.cefetmg.gestaodechamadas.service;

import br.cefetmg.gestaodechamadas.model.Turma;
import br.cefetmg.gestaodechamadas.repository.TurmaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TurmaService {

    private final TurmaRepository turmaRepository;

    public Turma getById(Long id) {
        return turmaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Turma não encontrada"));
    }

    public Turma create(Turma turma) {
        if (turma.getIdTurma() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }
        return turmaRepository.save(turma);
    }

    public List<Turma> getAll() {
        return turmaRepository.findAll();
    }

    public Turma update(Turma turma) {
        if (turma.getIdTurma() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }
        return turmaRepository.save(turma);
    }

    public Turma delete(Long id) {
        Turma turma = getById(id);
        turmaRepository.delete(turma);
        return turma;
    }
}