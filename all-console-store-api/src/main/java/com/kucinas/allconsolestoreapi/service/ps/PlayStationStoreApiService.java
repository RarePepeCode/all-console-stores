package com.kucinas.allconsolestoreapi.service.ps;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;
import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;
import com.kucinas.allconsolestoreapi.service.api.AbstractStoreApiService;
import com.kucinas.allconsolestoreapi.service.repository.game.GameRepository;

/**
 * Service for making api calls to get data from PlayStation store
 * 
 * @author Ignas Kucinas
 *
 */
@Service
public class PlayStationStoreApiService extends AbstractStoreApiService {

	final static String ALL_GAMES_URL_START = "https://store.playstation.com/chihiro-api/viewfinder/SA/en/999/STORE-MSF75508-FULLGAMES?size=99&gkb=1&geoCountry=EU&start=";
	final static String ALL_GAMES_URL_END = "&game_content_type=games";

	@Autowired
	private GameRepository entityManager;

	/**
	 * Gets and parses all the games in the store
	 * 
	 * @return the list of all games
	 * @throws IOException   Exception
	 * @throws JSONException Exception
	 */
	public List<Game> getAllGamesList() throws JSONException, IOException {
		List<Game> gamesData = new ArrayList<>();
		return retrieveGames(gamesData, 0);
	}

	/**
	 * The api can only return maximum of 99 games at one call so this needs to be
	 * called recursively until all games data are retrieved
	 * 
	 * @return List of parsed {@link Games}
	 */
	private List<Game> retrieveGames(List<Game> tempGamesData, Integer startGameNr) throws IOException, JSONException {
		List<Game> gamesData = tempGamesData;
		String fullUrl = ALL_GAMES_URL_START + startGameNr.toString() + ALL_GAMES_URL_END;

		WriteDataToDataFile(fullUrl);
		System.out.println(fullUrl);

		JSONObject object = new JSONObject(ReadDataFromDataFile());
		JSONArray gamesLink = object.getJSONArray("links");

		for (int i = 0; i < gamesLink.length(); i++) {
			Game game = parseGameData((JSONObject) gamesLink.get(i));
			if (game != null) {
				gamesData.add(game);
			}
		}
		entityManager.save(gamesData.get(1));

		if (gamesLink.length() == 99)
			return retrieveGames(gamesData, startGameNr + 99);

		return gamesData;
	}

	private Game parseGameData(JSONObject obj) throws JSONException {
		Game.Builder gameBuilder;
		if (correctJson(obj)) {
			gameBuilder = new Game.Builder();
			gameBuilder.setApiId(obj.getString("id"));
			gameBuilder.setName(cleanGamesName(obj.getString("title_name")));
			System.out.println(gameBuilder.getName());
			String dollarPrince = obj.getJSONObject("default_sku").getString("display_price");
			gameBuilder.setPrice(new BigDecimal(dollarPrince.substring(1)));
			JSONArray imagesArray = (JSONArray) obj.getJSONArray("images");
			if (imagesArray.length() > 1) {
				gameBuilder.setImageUrl(imagesArray.getJSONObject(0).getString("url"));
			}

			return gameBuilder.build();
		}
		System.out.println(obj.toString());
		return null;
	}

	private boolean correctJson(JSONObject obj) {
		if (obj.has("default_sku")) {
			if (obj.has("id") && obj.has("title_name")) {
				return true;
			} else {
				logJsonFormatWarning(obj);
			}
		}
		return false;
	}

	private static String cleanGamesName(String name) {
		return name.replaceAll("’", "'").replaceAll("™", "\u2122").replaceAll("®", "\u00AE").replaceAll(":�", ":")
				.replaceAll("ü", "u").replaceAll("–", "-");
	}

	@Override
	public PlatformType getPlatform() {
		return PlatformType.PS;
	}
}
