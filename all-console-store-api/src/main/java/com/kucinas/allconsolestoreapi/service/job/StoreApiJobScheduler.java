package com.kucinas.allconsolestoreapi.service.job;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.service.ps.PlayStationStoreApiService;

/**
 * Scheduler class for managing updates for {@link Game} for different game
 * stores
 * 
 * @author Ignas Kucinas
 *
 */
@Configuration
@EnableScheduling
public class StoreApiJobScheduler {

	PlayStationStoreApiService playStationStoreApiService;

	@PersistenceContext
	private EntityManager entityManager;

	/**
	 * Constructor
	 * 
	 * @param playStationStoreApiService the play station store api service
	 */
	@Autowired
	public StoreApiJobScheduler(PlayStationStoreApiService playStationStoreApiService) {
		this.playStationStoreApiService = playStationStoreApiService;
	}

	/**
	 * Job for updating data from playstation store
	 * 
	 * @throws JSONException exception
	 * @throws IOException   exception
	 */
	@Scheduled(cron = "0/10 * * ? * *")
	public void playstationStoreJob() throws JSONException, IOException {

//		List<Game> allGames = playStationStoreApiService.getAllGamesList(new ArrayList<>(), 0);
//		entityManager.persist(allGames.get(0));
		long now = System.currentTimeMillis() / 1000;
		System.out.println("schedule tasks using cron jobs - " + now);
	}

}
