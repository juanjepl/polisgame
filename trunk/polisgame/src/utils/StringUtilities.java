package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class StringUtilities {

	/**
	 * This method splits a String using another String like delimiter
	 * @param theString
	 * @param delimiter
	 * @return
	 */
	public static List<String> stringSplitterForPolis(String theString, String delimiter){
		List<String> wordsOfString = new ArrayList<String>();
		String[]words = theString.split(delimiter);
		wordsOfString = Arrays.asList(words);
		return wordsOfString;
	}
}
