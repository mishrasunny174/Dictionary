package dictionary;

import java.io.IOException;

import org.codehaus.jackson.map.ObjectMapper;

public class Dictionary {
	public static Data getData(String word) throws UnableToConnectException, IOException, NotFoundException{
		String response=null;
		Data data=null;
		try {
			response = DictionaryConnection.getResponse(word);
			if (response.equals("[]\n")) {
				throw new NotFoundException("Word Not Found");
			}
			response = "{\"results\":"+response+"}";
			ObjectMapper mapper = new ObjectMapper();
			data = mapper.readValue(response, Data.class);
		} catch (UnableToConnectException e) {
			System.err.println("[Debug] "+e.getMessage());
			System.out.println("[Debug] response = "+response);
			throw e;
		} catch (IOException e) {
			System.err.println("[Debug] unable to parse json file");
			throw e;
		} 
		return data;
	}
}
