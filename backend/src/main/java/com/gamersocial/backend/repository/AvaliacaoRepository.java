package com.gamersocial.backend.repository;

import com.gamersocial.backend.model.Avaliacao;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long> {
    List<Avaliacao> findByJogoId(Long jogoId);
}