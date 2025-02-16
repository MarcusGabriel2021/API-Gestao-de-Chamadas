package br.cefetmg.gestaodechamadas.controller;

import br.cefetmg.gestaodechamadas.model.Aula;
import br.cefetmg.gestaodechamadas.service.AulaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/aula")
@CrossOrigin(origins = "http://localhost:5173")
public class AulaController {

    @Autowired
    private final AulaService aulaService;

    public AulaController(AulaService aulaService) {
        this.aulaService = aulaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Aula> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(aulaService.getById(id));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Aula>> getAll() {
        return ResponseEntity.ok().body(aulaService.getAll());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Aula> create(@Valid @RequestBody Aula aula) {
        aula = aulaService.create(aula);
        return ResponseEntity.ok().body(aula);
    }

    @PutMapping({"", "/"})
    public ResponseEntity<Aula> update(@Valid @RequestBody Aula aula) {
        aula = aulaService.update(aula);
        return ResponseEntity.ok().body(aula);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Aula> delete(@PathVariable Long id) {
        Aula aula = aulaService.delete(id);
        return ResponseEntity.ok().body(aula);
    }
}
