package com.kucinas.allconsolestoreapi.service.entity;

import java.util.List;
import java.util.Optional;

import com.kucinas.allconsolestoreapi.model.entity.IEntity;

/**
 * Interface for all Services that are related to {@link IEntity}
 * 
 * @author Ignas Kucinas
 *
 * @param <E> entity for the which Service is configurated
 */
public interface IEntityCrudService<E extends IEntity> {

	/**
	 * Return entity by its id
	 * 
	 * @param id the id of entity
	 * @return entity
	 */
	Optional<E> get(Long id);

	/**
	 * Returns all entities in the DB
	 * 
	 * @return list of entities
	 */
	List<E> getAll();

	/**
	 * Saves or updates entity in the DB
	 * 
	 * @param entity the entity
	 * @return saved entity
	 */
	E save(E entity);

	/**
	 * Deletes the entity from the DB
	 * 
	 * @param entity the entity which should be deleted
	 */
	void delete(E entity);

}
