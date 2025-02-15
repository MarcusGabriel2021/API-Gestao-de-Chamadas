package br.cefetmg.gestaodechamadas.service;

import br.cefetmg.gestaodechamadas.model.Membro;
import br.cefetmg.gestaodechamadas.repository.MembroRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MembroService {

    private final MembroRepository membroRepository;

    public Membro getById(Long id) {
        return membroRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Membro não encontrado"));
    }

    public Membro create(Membro membro) {
        if (membro.getIdMembro() != null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id não deve ser informado");
        }
        return membroRepository.save(membro);
    }

    public List<Membro> getAll() {
        return membroRepository.findAll();
    }

    public Membro update(Membro membro) {
        if (membro.getIdMembro() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id deve ser informado");
        }
        return membroRepository.save(membro);
    }

    public Membro delete(Long id) {
        Membro membro = getById(id);
        membroRepository.delete(membro);
        return membro;
    }
}