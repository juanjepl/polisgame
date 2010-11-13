package utils;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

/** This class reads a directory's elements */
public class GenericDirectoryReader {

	public GenericDirectoryReader(){}
	
	/** this method reads a directory and returns a list with all texts (n lists of string) */ 
	public static List<List<String>> getDirectoryFiles(String directoryName){
		
		List<List<String>> directoryFiles = new ArrayList<List<String>>(); 
			
		File directory = new File(directoryName); // a directory also is a file
		String filesInDirectory[] = directory.list(); // gets the files in the directory
		
		for(String f:filesInDirectory){	 // iteration on all files in the directory
			if(f.endsWith(".pol")){	// if the file that we're reading ends with .pol (to differentiate and ignore other file extensions like .jpg)
				directoryFiles.add(GenericReader.getFileContents(f)); // calls the individual file reader, and adds the list(a file-> list of strings, one per line) to the list of lists (all files in directory)
			}
		}
	
		return directoryFiles;
	}
	
}
