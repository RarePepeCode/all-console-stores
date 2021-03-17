package com.kucinas.allconsolestoreapi.service.repository.game;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;

/**
 * JPA Repository for {@link Game}
 * 
 * @author Ignas Kucinas
 *
 */
@Repository
public interface GameRepository extends JpaRepository<Game, Long> {

}
