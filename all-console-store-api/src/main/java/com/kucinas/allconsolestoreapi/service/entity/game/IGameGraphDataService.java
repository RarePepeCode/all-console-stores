package com.kucinas.allconsolestoreapi.service.entity.game;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.model.entity.game.GameGraphData;
import com.kucinas.allconsolestoreapi.service.entity.IEntityCrudService;

/**
 * Service for managing {@link GameGraphData}
 * 
 * @author Ignas Kucinas
 *
 */
public interface IGameGraphDataService extends IEntityCrudService<GameGraphData> {

	/**
	 * Updates {@link Game} price change;
	 * 
	 * @param game the game for which data is being updated
	 */
	void updateGamesPrice(Game game);

}
