package com.kucinas.allconsolestoreapi.model.entity.game;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

import com.kucinas.allconsolestoreapi.model.IBuilder;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
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
	
	
	
	public Game(String apiId, String name, BigDecimal price, String imageUrl, PlatformType platform) {
		this.apiId = apiId;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.platform = platform;
	}



	public static class Builder implements IBuilder<Game> {

		private String apiId;
		private String name;
		private BigDecimal price;
		private String imageUrl;
		private PlatformType platform;
		

		public String getApiId() {
			return apiId;
		}

		public void setApiId(String apiId) {
			this.apiId = apiId;
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
			return new Game(apiId, name, price, imageUrl, platform);
		}
		
	}

}
 