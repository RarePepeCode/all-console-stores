package com.kucinas.allconsolestoreapi;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.service.ps.PlayStationStoreApiService;

@SpringBootApplication
public class AllConsoleStoreApiApplication {

	public static void main(String[] args) throws JSONException, IOException {
		SpringApplication.run(AllConsoleStoreApiApplication.class, args);
		System.out.print("Ciki");
		PlayStationStoreApiService psService = new PlayStationStoreApiService();
		List<Game> allGames = psService.getAllGamesList(new ArrayList<>(), 0);
	}

}
