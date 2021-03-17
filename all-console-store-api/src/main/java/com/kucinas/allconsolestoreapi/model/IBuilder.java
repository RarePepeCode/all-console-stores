package com.kucinas.allconsolestoreapi.model;

/**
 * Builder for creating new objects
 * 
 * @author Ignas Kucinas
 *
 * @param <E> Object for which builder is created
 */
public interface IBuilder<E> {

	/**
	 * Builds Objects from set properties
	 * 
	 * @return new object
	 */
	E build();

}
