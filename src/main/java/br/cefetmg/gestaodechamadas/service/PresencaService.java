package br.cefetmg.gestaodechamadas.service;

import br.cefetmg.gestaodechamadas.model.Presenca;
import br.cefetmg.gestaodechamadas.repository.PresencaRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PresencaService {

    private final PresencaRepository presencaRepository;

    public Presenca getById(Long id) {
        return presencaRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Presença não encontrada"));
    }

    public Presenca create(Presenca presenca) {
        if (presenca.getIdPresenca() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }
        return presencaRepository.save(presenca);
    }

    public List<Presenca> getAll() {
        return presencaRepository.findAll();
    }

    public Presenca update(Presenca presenca) {
        if (presenca.getIdPresenca() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }
        return presencaRepository.save(presenca);
    }

    public Presenca delete(Long id) {
        Presenca presenca = getById(id);
        presencaRepository.delete(presenca);
        return presenca;
    }
}