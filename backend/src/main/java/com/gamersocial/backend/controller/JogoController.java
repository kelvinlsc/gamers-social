package com.gamersocial.backend.controller;

import com.gamersocial.backend.model.Jogo;
import com.gamersocial.backend.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/jogos")
@CrossOrigin(origins = "*")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    // GET /jogos - listar todos
    @GetMapping
    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    // GET /jogos/busca?termo=texto - busca por nome OU gênero (case insensitive)
    @GetMapping("/busca")
    public List<Jogo> buscar(@RequestParam(required = false) String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return jogoRepository.findAll();
        }
        return jogoRepository.findByNomeContainingIgnoreCaseOrGeneroContainingIgnoreCase(termo.trim(), termo.trim());
    }

    // POST /jogos - criar jogo
    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    // DELETE /jogos/{id} - deletar jogo
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (jogoRepository.existsById(id)) {
            jogoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}