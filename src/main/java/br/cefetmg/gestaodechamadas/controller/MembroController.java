package br.cefetmg.gestaodechamadas.controller;

import br.cefetmg.gestaodechamadas.model.Membro;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "api/v1/membro")
public class MembroController {

    private static long nextId = 1;
    private static List listaDeMembros = new ArrayList();

    @PostMapping("/")
    public Membro inserir(@RequestBody Membro membro) {

        membro.setId(nextId);
        membro.setNome(membro.getNome());
        nextId++;
        listaDeMembros.add(membro);
        System.out.println(membro);
        return membro;

    }

}
