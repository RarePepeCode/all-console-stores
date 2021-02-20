package com.kucinas.allconsolestoreapi.model.entity.game;

import lombok.Data;

@Data
public class GameGraphData implements IGameGraphData {
	
	private Long id;
	private Long gameId;
	private String priceData;
	private String dateData;
}
