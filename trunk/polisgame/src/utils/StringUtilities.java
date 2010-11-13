package utils;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

/** Class with string utility methods */
public class StringUtilities {

	/**  This method splits a String using another String like delimiter */
	public static List<String> stringSplitterForPolis(String theString, String delimiter){
		List<String> wordsOfString = new ArrayList<String>();
		String[]words = theString.split(delimiter); // Sets the array with the string cut in some parts (many as delimiters)
		wordsOfString = Arrays.asList(words); // converts array into a List
		return wordsOfString;
	}
	
	// more methods?
}
