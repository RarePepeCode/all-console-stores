package com.kucinas.allconsolestoreapi.model.entity.game;

import java.math.BigDecimal;

import com.kucinas.allconsolestoreapi.model.entity.IEntity;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;

public interface IGame extends IEntity {


	public String getApiId();

	public String getName();

	public BigDecimal getPrice();

	public String getImageUrl();

	public PlatformType getPlatform();
	
}
