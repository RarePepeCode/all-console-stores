package com.kucinas.allconsolestoreapi;

import java.io.IOException;
import java.util.List;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.service.ps.PlayStationStoreApiService;

/**
 * Application Runner
 * 
 * @author Ignas Kucinas
 *
 */
@SpringBootApplication
public class AllConsoleStoreApiApplication {

	/**
	 * main method
	 * 
	 * @param args the arguments
	 * @throws JSONException exception
	 * @throws IOException   exception
	 */
	public static void main(String[] args) throws JSONException, IOException {
		SpringApplication.run(AllConsoleStoreApiApplication.class, args);
		System.out.print("Ciki");
		PlayStationStoreApiService psService = new PlayStationStoreApiService();
		List<Game> allGames = psService.getAllGamesList();
	}

}
