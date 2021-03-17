package com.kucinas.allconsolestoreapi.service.repository.game;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.model.entity.game.GameGraphData;

/**
 * JPA Repository for {@link GameGraphData}
 * 
 * @author Ignas Kucinas
 *
 */
@Repository
public interface GameGraphDataRepository extends JpaRepository<GameGraphData, Long> {

	/**
	 * Finds the {@link GameGraphData} by {@link Game} id
	 * 
	 * @param games_id the {@link Game} id
	 * @return the Game graph data
	 */
	public Optional<GameGraphData> findByGames_id(Long games_id);
}
