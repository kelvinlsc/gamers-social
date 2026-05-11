package com.gamersocial.backend.repository;

import com.gamersocial.backend.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
    List<Jogo> findByNomeContainingIgnoreCaseOrGeneroContainingIgnoreCase(String nome, String genero);
}