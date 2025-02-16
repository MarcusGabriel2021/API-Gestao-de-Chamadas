package br.cefetmg.gestaodechamadas.controller;

import br.cefetmg.gestaodechamadas.model.Membro;
import br.cefetmg.gestaodechamadas.service.MembroService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/membro")
@CrossOrigin(origins = "http://localhost:5173")
public class MembroController {

    @Autowired
    private final MembroService membroService;

    public MembroController(MembroService membroService) {
        this.membroService = membroService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Membro> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(membroService.getById(id));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Membro>> getAll() {
        return ResponseEntity.ok().body(membroService.getAll());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Membro> create(@Valid @RequestBody Membro membro) {
        membro = membroService.create(membro);
        return ResponseEntity.ok().body(membro);
    }

    @PutMapping({"", "/"})
    public ResponseEntity<Membro> update(@Valid @RequestBody Membro membro) {
        membro = membroService.update(membro);
        return ResponseEntity.ok().body(membro);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Membro> delete(@PathVariable Long id) {
        Membro membro = membroService.delete(id);
        return ResponseEntity.ok().body(membro);
    }
}
