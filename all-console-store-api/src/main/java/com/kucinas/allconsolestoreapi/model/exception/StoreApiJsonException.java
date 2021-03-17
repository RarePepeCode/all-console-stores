package com.kucinas.allconsolestoreapi.model.exception;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;

/**
 * Exception for when json format is incorrect for parser
 * 
 * @author Ignas Kucinas
 *
 */
public class StoreApiJsonException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 9101478684631594800L;

	/**
	 * Constructor
	 * 
	 * @param platform platform for which {@link Game} was being parsed
	 * @param json     the json of {@link Game}
	 */
	public StoreApiJsonException(PlatformType platform, String json) {
		super("Incorrect json format for " + platform + " json: " + json);
	}
}
