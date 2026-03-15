package com.gamerssocial.backend.controller;

import com.gamerssocial.backend.model.Jogo;
import com.gamerssocial.backend.repository.JogoRepository;
import org.springframework.beans.factory.annotation.Autowired;
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

    @GetMapping("/{id}")
    public Jogo buscarPorId(@PathVariable Long id) {
        return jogoRepository.findById(id).orElse(null);
    }

    @PostMapping
    public Jogo cadastrar(@RequestBody Jogo jogo) {
        return jogoRepository.save(jogo);
    }

    @PutMapping("/{id}")
    public Jogo atualizar(@PathVariable Long id, @RequestBody Jogo jogoAtualizado) {
        Optional<Jogo> jogoExistente = jogoRepository.findById(id);

        if (jogoExistente.isPresent()) {
            Jogo jogo = jogoExistente.get();
            jogo.setNome(jogoAtualizado.getNome());
            jogo.setGenero(jogoAtualizado.getGenero());
            jogo.setPlataforma(jogoAtualizado.getPlataforma());
            return jogoRepository.save(jogo);
        }

        return null;
    }

    @DeleteMapping("/{id}")
    public String deletar(@PathVariable Long id) {
        if (jogoRepository.existsById(id)) {
            jogoRepository.deleteById(id);
            return "Jogo deletado com sucesso!";
        }
        return "Jogo não encontrado!";
    }
}
