package dictionary;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;

public class DictionaryConnection {
	private static final String baseUrl = "https://owlbot.info/api/v2/dictionary/";

	public static String getResponse(String word) throws UnableToConnectException {
		String result = null;
		try {
			String address = baseUrl+word+"?format=json";
			URL url = new URL(address);
			URLConnection connection = url.openConnection();
			connection.setRequestProperty("Accept","text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8");
			connection.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:59.0) Gecko/20100101 Firefox/59.0");
			try (InputStreamReader responseReader = new InputStreamReader(connection.getInputStream());
					BufferedReader response = new BufferedReader(responseReader)) {
				StringBuilder responseBuilder = new StringBuilder();
				String line = null;
				while ((line = response.readLine()) != null)
					responseBuilder.append(line + "\n");
				result = responseBuilder.toString();
			}
		} catch (IOException e) {
			System.err.println("[Debug] "+e.getMessage());
			throw new UnableToConnectException("Unable to connect to API");
		}
		return result;
	}
}
