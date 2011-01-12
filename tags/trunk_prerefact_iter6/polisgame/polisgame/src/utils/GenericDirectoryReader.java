package utils;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import exceptions.PolisGameRunningException;

/**
 * This class reads all elements of a directory
 * and returns a List, with Strings lists (one list of strings
 * per file in directory)
 */
public class GenericDirectoryReader {

	public GenericDirectoryReader(){}
	
	/** this method reads a directory and returns a list with all texts (n lists of string) */ 
	public static List<List<String>> getDirectoryFilesContents(String directoryName){
		List<List<String>> directoryFilesContents = new ArrayList<List<String>>(); 
		File directory = new File(directoryName); // (a directory also is a file)
		
		if(!(directory.exists())){
			throw new PolisGameRunningException("Folder not exists when getDirectoryFilesContents() has tried to read them");
		}
		
		String filesInDirectory[] = directory.list(); // gets the files in the directory
		
		for(String f : filesInDirectory){ // iteration on all files in the directory
			if(f.endsWith(".pol")){	// if the file that we're reading ends with ".pol" (to differentiate and ignore other file extensions like ".jpg")
				directoryFilesContents.add(GenericReader.getFileContents(directoryName+f)); // calls the individual file reader
			}
		}
		return directoryFilesContents;
	}
	
	/** this method reads a directory and returns a Map with filenames and all texts */ 
	public static Map<String, List<String>> getDirectoryFilesContentsInAMap(String directoryName){
		Map<String,List<String>> directoryFilesContents = new HashMap<String,List<String>>(); 
		File directory = new File(directoryName); // a directory also is a file
		
		if(!(directory.exists())){
			throw new PolisGameRunningException("Folder not exists when getDirectoryFilesContentsInAMap() has tried to read them");
		}
		
		String filesInDirectory[] = directory.list(); // gets the files in the directory
		
		for(String f:filesInDirectory){ // iteration on all files in the directory
			if(f.endsWith(".pol")){	// if the file that we're reading ends with ".pol" (to differentiate and ignore other file extensions like ".jpg")
				directoryFilesContents.put(f,GenericReader.getFileContents(directoryName+f)); // calls the individual file reader
			}
		}
		return directoryFilesContents;
	}
}