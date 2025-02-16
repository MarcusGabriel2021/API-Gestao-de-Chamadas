package br.cefetmg.gestaodechamadas.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/")
@CrossOrigin(origins = "http://localhost:5173")
public class HomeController {

    @GetMapping("")
    public String home() {
        return "<h1> Home </h1>";
    }

}
