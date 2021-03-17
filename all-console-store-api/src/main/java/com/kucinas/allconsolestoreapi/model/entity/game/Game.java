package com.kucinas.allconsolestoreapi.model.entity.game;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.kucinas.allconsolestoreapi.model.IBuilder;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;

import lombok.Getter;
import lombok.Setter;

/**
 * Implementation of {@link IGame}
 * 
 * @author Ignas Kucinas
 *
 */
@Getter
@Setter
@Entity
@Table(name = "games")
public class Game implements IGame {

	@Id
	private Long id;

	@Column
	private String apiId;

	@Column
	private String name;

	@Column
	private BigDecimal price;

	@Column
	private String imageUrl;

	@Column
	private PlatformType platform;

	/**
	 * Constructor
	 * 
	 * @param apiId    the id of game in api call
	 * @param name     the name of game
	 * @param price    the price of game
	 * @param imageUrl the image of game
	 * @param platform the platform of game
	 */
	public Game(String apiId, String name, BigDecimal price, String imageUrl, PlatformType platform) {
		this.apiId = apiId;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.platform = platform;
	}

	/**
	 * Builder for creating new instance of {@link Game}
	 * 
	 * @author Ignas Kucinas
	 *
	 */
	public static class Builder implements IBuilder<Game> {

		private String apiId;
		private String name;
		private BigDecimal price;
		private String imageUrl;
		private PlatformType platform;

		/**
		 * Sets id from api call
		 * 
		 * @param apiId the id of game in api call
		 */
		public void setApiId(String apiId) {
			this.apiId = apiId;
		}

		/**
		 * The name of the Game
		 * 
		 * @return builder
		 */
		public String getName() {
			return name;
		}

		/**
		 * Sets name of the game
		 * 
		 * @param name the name of the Game
		 */
		public void setName(String name) {
			this.name = name;
		}

		/**
		 * Sets price of the game
		 * 
		 * @param price the price of game
		 */
		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		/**
		 * Sets url to games image
		 * 
		 * @param imageUrl the url of games image
		 */
		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		/**
		 * Sets gaming platform of the game
		 * 
		 * @param platform the gaming platform
		 */
		public void setPlatform(PlatformType platform) {
			this.platform = platform;
		}

		@Override
		public Game build() {
			return new Game(apiId, name, price, imageUrl, platform);
		}

	}

}
