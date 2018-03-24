package dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class dictionaryConnection {
	private final String appId = "48e7796a"; // Oxford dictionary API application id
	private final String appKey = "07caaadef0e673dca3b8a90b465ba425"; // Oxford dictionary API application key
	private String language = ""; // language for dictionary

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getResponse(String word) {
		String url = "https://od-api.oxforddictionaries.com/api/v1/entries/" + language + "/" + word.toLowerCase();
		String response = null;
		try {
			URLConnection oxfordConnection = new URL(url).openConnection();
			oxfordConnection.setRequestProperty("app_id", appId);
			oxfordConnection.setRequestProperty("app_key", appKey);
			oxfordConnection.setRequestProperty("Accept", "application/json");
			StringBuilder responseBuilder = new StringBuilder();
			String line = null;
			try (InputStreamReader responseReader = new InputStreamReader(oxfordConnection.getInputStream());
					BufferedReader bufferedResponseReader = new BufferedReader(responseReader)) {
				while ((line = bufferedResponseReader.readLine()) != null) {
					responseBuilder.append(line + "\n");
				}
			}
			response = responseBuilder.toString();
		} catch (MalformedURLException e) {
			System.err.println("[Debug] wrong url");
			return null;
		} catch (IOException e) {
			System.err.println("[Debug] unable to open connection to oxford website");
			return null;
		}
		return response;
	}

	public dictionaryConnection(String language) {
		this.language = language;
	}

	public dictionaryConnection() {
		this.language = "en"; //default language will be english
	}

}
