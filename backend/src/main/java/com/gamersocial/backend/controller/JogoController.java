package com.gamersocial.backend.controller;

import com.gamersocial.backend.model.Jogo;
import com.gamersocial.backend.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/jogos")
@CrossOrigin(origins = "*")
public class JogoController {

    @Autowired
    private JogoRepository jogoRepository;

    @GetMapping
    public List<Jogo> listar() {
        return jogoRepository.findAll();
    }

    @GetMapping("/busca")
    public List<Jogo> buscar(@RequestParam(required = false) String termo) {
        if (termo == null || termo.trim().isEmpty()) {
            return jogoRepository.findAll();
        }
        return jogoRepository.findByNomeContainingIgnoreCaseOrGeneroContainingIgnoreCase(
                termo.trim(), termo.trim()
        );
    }

    @PostMapping
    public Jogo criar(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Jogo> atualizar(@PathVariable Long id, @RequestBody Jogo jogoAtualizado) {
        Optional<Jogo> jogoOpt = jogoRepository.findById(id);

        if (jogoOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Jogo jogo = jogoOpt.get();
        jogo.setNome(jogoAtualizado.getNome());
        jogo.setGenero(jogoAtualizado.getGenero());
        jogo.setPlataforma(jogoAtualizado.getPlataforma());

        return ResponseEntity.ok(jogoRepository.save(jogo));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        if (jogoRepository.existsById(id)) {
            jogoRepository.deleteById(id);
            return ResponseEntity.ok().build();
        }
        return ResponseEntity.notFound().build();
    }
}