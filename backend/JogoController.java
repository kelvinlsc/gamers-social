package com.gamersocial.controller;

import com.gamersocial.model.Jogo;
import com.gamersocial.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/jogos")
@CrossOrigin(origins = "*")
public class JogoController {
    
    @Autowired
    private JogoRepository repo;
    
    @PostMapping
    public Jogo cadastrar(@RequestBody Jogo jogo) {
        return repo.save(jogo);
    }
    
    @GetMapping
    public List<Jogo> listar() {
        return repo.findAll();
    }
}
