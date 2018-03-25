package dictionary;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class Dictionary {
	public static Data getData(String word){
		Data data=null;
		try {
			String response = DictionaryConnection.getResponse(word);
			response = "{\"results\":"+response+"}";
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(response, Data.class);
		} catch (UnableToConnectException e) {
			System.err.println("[Debug] "+e.getMessage());
			System.exit(-1);
		} catch (IOException e) {
			System.err.println("[Debug] unable to parse json file");
			System.exit(-1);
		} 
		return data;
	}
}
