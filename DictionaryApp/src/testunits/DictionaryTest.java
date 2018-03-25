package testunits;

import dictionary.Data;
import dictionary.Dictionary;
import dictionary.Result;

public class DictionaryTest {
	public static void main(String[] args) {
		Data data = Dictionary.getData("love");
		Result[] results = data.getResults();
		System.out.println("Word: love");
		System.out.println("Definitions");
		for (Result result : results) {
			System.out.println(result.getType());
			System.out.println();
		}
	}
}
