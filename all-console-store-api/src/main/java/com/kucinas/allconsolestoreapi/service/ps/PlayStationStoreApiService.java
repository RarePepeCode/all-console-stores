package com.kucinas.allconsolestoreapi.service.ps;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.kucinas.allconsolestoreapi.model.entity.game.Game;

@Service
public class PlayStationStoreApiService {


	final static String ALL_GAMES_URL_START = "https://store.playstation.com/chihiro-api/viewfinder/SA/en/999/STORE-MSF75508-FULLGAMES?size=99&gkb=1&geoCountry=EU&start=";
	final static String ALL_GAMES_URL_END = "&game_content_type=games";
	final static String DATA_FILE = "data.txt";

	public PlayStationStoreApiService() {
		
	}
	
	public static List<Game> getAllGamesList(List<Game> tempgamesData, Integer startGameNr) throws IOException, JSONException {
		List<Game> gamesData = tempgamesData;
		String fullUrl = ALL_GAMES_URL_START+startGameNr.toString()+ALL_GAMES_URL_END;
		
		WriteDataToDataFile(fullUrl);
		System.out.println(fullUrl);

        JSONObject object = new JSONObject(ReadDataFromDataFile());
		JSONArray gamesLink = object.getJSONArray("links");
		
        for (int i = 0; i < gamesLink.length(); i++) {
            gamesData.add(parseGameData((JSONObject) gamesLink.get(i)));
        }
        
        if (gamesLink.length() == 99)
        	return getAllGamesList(gamesData, startGameNr + 99);
        
		return gamesData;
	}
	
	public static void WriteDataToDataFile(String path) throws IOException {
		URL url = new URL(path);
		byte buf[] = new byte[4096];
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fos = new FileOutputStream(DATA_FILE);

		int bytesRead = 0;
		while((bytesRead = bis.read(buf)) != -1) {
			fos.write(buf, 0, bytesRead);
		}
		fos.flush();
	   	fos.close();
	   	bis.close();
	}
	
	public static String ReadDataFromDataFile() throws IOException {
		return new String(Files.readAllBytes(Paths.get(DATA_FILE))); 
	}
	
	public static Game parseGameData(JSONObject obj) throws JSONException {
		Game.Builder gameBuilder;
		if (obj.has("default_sku")) {
			gameBuilder = new Game.Builder();
			gameBuilder.setGameStoreId(obj.getString("id"));
			gameBuilder.setName(cleanGamesName(obj.getString("title_name")));
			System.out.println(gameBuilder.getName());
			if (gameBuilder.getName().equals("WRC 8 FIA World Rally Championship")) {
				System.out.println( obj.getJSONObject("default_sku").getString("display_price"));
			}
			else {
				String dollarPrince = obj.getJSONObject("default_sku").getString("display_price");
				gameBuilder.setPrice(new BigDecimal(dollarPrince.substring(1)));
			}
			JSONArray imagesArray = (JSONArray) obj.getJSONArray("images");
			if (imagesArray.length() > 1) {
				gameBuilder.setImageUrl(imagesArray.getJSONObject(0).getString("url"));
			}
			


			return gameBuilder.build();
		}
		return null;

	}
	
	public static String cleanGamesName(String name) {
		name = name.replaceAll("’", "'");
		name = name.replaceAll("™", "\u2122");
		name = name.replaceAll("®", "\u00AE");
		name = name.replaceAll(":�", ":");
		name = name.replaceAll("ü", "u");
		name = name.replaceAll("–", "-");
		
		return name;
	}
}
