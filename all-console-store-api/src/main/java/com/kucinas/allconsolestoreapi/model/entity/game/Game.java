package com.kucinas.allconsolestoreapi.model.entity.game;

import java.math.BigDecimal;

import com.kucinas.allconsolestoreapi.model.IBuilder;
import com.kucinas.allconsolestoreapi.model.entity.IEntity;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Game implements IEntity {
	
	private Long id;
	private String gameStoreId;
	private String name;
	private BigDecimal price;
	private String imageUrl;
	private PlatformType platform;
	
	
	
	public Game(String gameStoreId, String name, BigDecimal price, String imageUrl, PlatformType platform) {
		this.gameStoreId = gameStoreId;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.platform = platform;
	}



	public static class Builder implements IBuilder<Game> {

		private String gameStoreId;
		private String name;
		private BigDecimal price;
		private String imageUrl;
		private PlatformType platform;
		
		
		public String getGameStoreId() {
			return gameStoreId;
		}

		public void setGameStoreId(String gameStoreId) {
			this.gameStoreId = gameStoreId;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public BigDecimal getPrice() {
			return price;
		}

		public void setPrice(BigDecimal price) {
			this.price = price;
		}

		public String getImageUrl() {
			return imageUrl;
		}

		public void setImageUrl(String imageUrl) {
			this.imageUrl = imageUrl;
		}

		public PlatformType getPlatform() {
			return platform;
		}

		public void setPlatform(PlatformType platform) {
			this.platform = platform;
		}

		@Override
		public Game build() {
			return new Game(gameStoreId, name, price, imageUrl, platform);
		}
		
	}

}
 