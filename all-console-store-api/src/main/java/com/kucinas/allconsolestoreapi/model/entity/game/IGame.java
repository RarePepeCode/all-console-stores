package com.kucinas.allconsolestoreapi.model.entity.game;

import java.math.BigDecimal;

import com.kucinas.allconsolestoreapi.model.entity.IEntity;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;

/**
 * Entity contains data, thats needed for app
 * 
 * @author Ignas Kucinas
 *
 */
public interface IGame extends IEntity {

	/**
	 * Getter of id from api call
	 * 
	 * @return the id of game in api call
	 */
	public String getApiId();

	/**
	 * Getter of name of the game
	 * 
	 * @return name of the Game
	 */
	public String getName();

	/**
	 * Getter of price of the game
	 * 
	 * @return price of game
	 */
	public BigDecimal getPrice();

	/**
	 * Getter of url to games image
	 * 
	 * @return url of games image
	 */
	public String getImageUrl();

	/**
	 * Getter of gaming platform of the game
	 * 
	 * @return gaming platform
	 */
	public PlatformType getPlatform();

}
