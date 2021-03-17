package com.kucinas.allconsolestoreapi.model.entity.game;

import com.kucinas.allconsolestoreapi.model.entity.IEntity;

/**
 * Entity for saving {@link Game} price for certain time
 * 
 * @author Ignas Kucinas
 *
 */
public interface IGameGraphData extends IEntity {

	/**
	 * Getter of game
	 * 
	 * @return game
	 */
	public Game getGame();

	/**
	 * Getter of of {@link Game} price change
	 * 
	 * @return the price change
	 */
	public String getPriceData();

	/**
	 * Getter of of {@link Game} date change
	 * 
	 * @return the date change
	 */
	public String getDateData();

	/**
	 * Setter of Game
	 * 
	 * @param game the game
	 */
	public void setGame(Game game);

	/**
	 * Setter of {@link Game} price change
	 * 
	 * @param priceData the price change
	 */
	public void setPriceData(String priceData);

	/**
	 * Setter of {@link Game} date change
	 * 
	 * @param dateData the date change
	 */
	public void setDateData(String dateData);

	/**
	 * Adds new data for price change
	 * 
	 * @param price the new price of the game
	 */
	public void appendGamesPriceData(String price);

}
