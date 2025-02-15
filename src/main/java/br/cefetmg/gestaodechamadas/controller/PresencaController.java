package br.cefetmg.gestaodechamadas.controller;

import br.cefetmg.gestaodechamadas.model.Presenca;
import br.cefetmg.gestaodechamadas.service.PresencaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/presenca")
@CrossOrigin(origins = "http://localhost:3000")
public class PresencaController {

    @Autowired
    private final PresencaService presencaService;

    public PresencaController(PresencaService presencaService) {
        this.presencaService = presencaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Presenca> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(presencaService.getById(id));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Presenca>> getAll() {
        return ResponseEntity.ok().body(presencaService.getAll());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Presenca> create(@Valid @RequestBody Presenca presenca) {
        presenca = presencaService.create(presenca);
        return ResponseEntity.ok().body(presenca);
    }

    @PutMapping({"", "/"})
    public ResponseEntity<Presenca> update(@Valid @RequestBody Presenca presenca) {
        presenca = presencaService.update(presenca);
        return ResponseEntity.ok().body(presenca);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Presenca> delete(@PathVariable Long id) {
        Presenca presenca = presencaService.delete(id);
        return ResponseEntity.ok().body(presenca);
    }
}
