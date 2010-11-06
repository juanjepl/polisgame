package utils;

import game.*;
import java.util.Map;
import java.util.HashMap;
import java.util.List;


public class PolReader { // Reads .pol files
	
	public PolReader(){}
	
	// This method reads all Seas files and returns a map with the Sea objects
	public static Map<String,Sea> readSeas(){
		String pathOfSeas = "/data/seas/";
		Map<String,Sea> seasMap = new HashMap<String,Sea>();

		List<List<String>> seasTexts = GenericDirectoryReader.getDirectoryFiles(pathOfSeas);
		
		
		for(List<String> seaInfo:seasTexts){
			seasMap.put(seaInfo.get(0), new Sea(seaInfo.get(0),seaInfo.get(1))); //TODO not tested!!
		}
		
		return seasMap;
	}
	
	
		
		
	
	
	
}
