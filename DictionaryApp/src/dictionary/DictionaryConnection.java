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
			URLConnection conncetion = url.openConnection();
			try (InputStreamReader responseReader = new InputStreamReader(conncetion.getInputStream());
					BufferedReader response = new BufferedReader(responseReader)) {
				StringBuilder responseBuilder = new StringBuilder();
				String line = null;
				while ((line = response.readLine()) != null)
					responseBuilder.append(line + "\n");
				result = responseBuilder.toString();
			}
		} catch (IOException e) {
			System.err.println("[Debug] Unable to connect to API");
			throw new UnableToConnectException("Unable to connect to API");
		}
		return result;
	}
}
