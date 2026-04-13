package com.gamersocial.backend.repository;

import com.gamersocial.backend.model.Jogo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogoRepository extends JpaRepository<Jogo, Long> {
}