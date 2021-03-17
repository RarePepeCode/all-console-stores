package com.kucinas.allconsolestoreapi.service.api;

import java.io.BufferedInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.kucinas.allconsolestoreapi.model.entity.platform.PlatformType;
import com.kucinas.allconsolestoreapi.model.exception.StoreApiJsonException;

/**
 * Abstract Api Service for getting games data
 * 
 * @author Ignas Kucinas
 *
 */
public abstract class AbstractStoreApiService {

	private static Logger log = LoggerFactory.getLogger(AbstractStoreApiService.class);

	final static String DATA_FILE_SUFFIX = "_data.txt";

	/**
	 * Gets current games platform
	 * 
	 * @return the game platform
	 */
	public abstract PlatformType getPlatform();

	protected void WriteDataToDataFile(String path) throws IOException {
		URL url = new URL(path);
		byte buf[] = new byte[4096];
		BufferedInputStream bis = new BufferedInputStream(url.openStream());
		FileOutputStream fos = new FileOutputStream(getFileName());

		int bytesRead = 0;
		while ((bytesRead = bis.read(buf)) != -1) {
			fos.write(buf, 0, bytesRead);
		}
		fos.flush();
		fos.close();
		bis.close();
	}

	protected String ReadDataFromDataFile() throws IOException {
		return new String(Files.readAllBytes(Paths.get(getFileName())));
	}

	protected void logJsonFormatWarning(JSONObject obj) {
		log.error("S", new StoreApiJsonException(getPlatform(), obj.toString()));
	}

	private String getFileName() {
		return getPlatform() + DATA_FILE_SUFFIX;
	}
}
