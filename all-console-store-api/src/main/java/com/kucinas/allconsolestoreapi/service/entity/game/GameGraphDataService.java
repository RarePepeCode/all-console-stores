package com.kucinas.allconsolestoreapi.service.entity.game;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.model.entity.game.GameGraphData;
import com.kucinas.allconsolestoreapi.service.repository.game.GameGraphDataRepository;

/**
 * Implementation of {@link IGameGraphDataService}
 * 
 * @author Ignas Kucinas
 *
 */
@Service
public class GameGraphDataService implements IGameGraphDataService {

	private GameGraphDataRepository gameGraphDataRepository;

	@Override
	public Optional<GameGraphData> get(Long id) {
		return gameGraphDataRepository.findById(id);
	}

	@Override
	public List<GameGraphData> getAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GameGraphData save(GameGraphData entity) {
		return gameGraphDataRepository.save(entity);
	}

	@Override
	public void delete(GameGraphData entity) {
		// TODO Auto-generated method stub

	}

	private Optional<GameGraphData> findByGamesId(Long gameId) {
		return gameGraphDataRepository.findByGames_id(gameId);
	}

	@Override
	public void updateGamesPrice(Game game) {
		Optional<GameGraphData> gameData = findByGamesId(game.getId());
		gameData.ifPresentOrElse((value) -> {
			value.appendGamesPriceData(game.getPrice().toString());
			save(value);
		}, () -> {
			GameGraphData newGameData = new GameGraphData(game);
			save(newGameData);
		});

	}

}
