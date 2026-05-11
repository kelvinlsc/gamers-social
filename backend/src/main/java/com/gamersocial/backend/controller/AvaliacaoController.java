package com.gamersocial.backend.controller;

import com.gamersocial.backend.model.Avaliacao;
import com.gamersocial.backend.model.Jogo;
import com.gamersocial.backend.model.User;
import com.gamersocial.backend.repository.AvaliacaoRepository;
import com.gamersocial.backend.repository.JogoRepository;
import com.gamersocial.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/avaliacoes")
@CrossOrigin(origins = "*")
public class AvaliacaoController {

    @Autowired
    private AvaliacaoRepository avaliacaoRepository;

    @Autowired
    private JogoRepository jogoRepository;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/jogo/{jogoId}")
    public List<Avaliacao> listarPorJogo(@PathVariable Long jogoId) {
        return avaliacaoRepository.findByJogoId(jogoId);
    }

    @PostMapping
    public ResponseEntity<?> salvar(@RequestBody AvaliacaoRequest request) {
        Optional<User> userOpt = userRepository.findById(request.getUserId());
        Optional<Jogo> jogoOpt = jogoRepository.findById(request.getJogoId());

        if (userOpt.isEmpty() || jogoOpt.isEmpty()) {
            return ResponseEntity.badRequest().body("Usuário ou jogo não encontrado.");
        }

        if (request.getEstrelas() == null || request.getEstrelas() < 1 || request.getEstrelas() > 5) {
            return ResponseEntity.badRequest().body("As estrelas devem ser entre 1 e 5.");
        }

        Avaliacao avaliacao = new Avaliacao();
        avaliacao.setUser(userOpt.get());
        avaliacao.setJogo(jogoOpt.get());
        avaliacao.setEstrelas(request.getEstrelas());

        return ResponseEntity.ok(avaliacaoRepository.save(avaliacao));
    }

    public static class AvaliacaoRequest {
        private Long userId;
        private Long jogoId;
        private Integer estrelas;

        public Long getUserId() {
            return userId;
        }

        public void setUserId(Long userId) {
            this.userId = userId;
        }

        public Long getJogoId() {
            return jogoId;
        }

        public void setJogoId(Long jogoId) {
            this.jogoId = jogoId;
        }

        public Integer getEstrelas() {
            return estrelas;
        }

        public void setEstrelas(Integer estrelas) {
            this.estrelas = estrelas;
        }
    }
}