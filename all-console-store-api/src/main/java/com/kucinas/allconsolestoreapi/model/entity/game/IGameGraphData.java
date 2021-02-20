package com.kucinas.allconsolestoreapi.model.entity.game;

import com.kucinas.allconsolestoreapi.model.entity.IEntity;

public interface IGameGraphData extends IEntity {
	
	public Long getGameId();
	
	public String getPriceData();
	
	public String getDateData();
	
	public void setGameId(Long gameId);
	
	public void setPriceData(String priceData);
	
	public void setDateData(String dateData);

}
