package br.cefetmg.gestaodechamadas.controller;

import br.cefetmg.gestaodechamadas.model.Turma;
import br.cefetmg.gestaodechamadas.service.TurmaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/turma")
@CrossOrigin(origins = "http://localhost:5173")
public class TurmaController {

    @Autowired
    private final TurmaService turmaService;

    public TurmaController(TurmaService turmaService) {
        this.turmaService = turmaService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Turma> getById(@PathVariable Long id) {
        return ResponseEntity.ok().body(turmaService.getById(id));
    }

    @GetMapping({"", "/"})
    public ResponseEntity<List<Turma>> getAll() {
        return ResponseEntity.ok().body(turmaService.getAll());
    }

    @PostMapping({"", "/"})
    public ResponseEntity<Turma> create(@Valid @RequestBody Turma turma) {
        turma = turmaService.create(turma);
        return ResponseEntity.ok().body(turma);
    }

    @PutMapping({"", "/"})
    public ResponseEntity<Turma> update(@Valid @RequestBody Turma turma) {
        turma = turmaService.update(turma);
        return ResponseEntity.ok().body(turma);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Turma> delete(@PathVariable Long id) {
        Turma turma = turmaService.delete(id);
        return ResponseEntity.ok().body(turma);
    }
}