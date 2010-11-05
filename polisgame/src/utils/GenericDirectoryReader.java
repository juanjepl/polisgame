package utils;

import java.io.*;
import java.util.List;
import java.util.ArrayList;

//FIXME not tested !!!!
public class GenericDirectoryReader {

	public GenericDirectoryReader(){}
	
	// this method returns a list with all texts (lists of string) 
	public static List<List<String>> getDirectoryFiles(String directoryName){
		
		List<List<String>> directoryFiles = new ArrayList<List<String>>(); 
			
		File directory = new File(directoryName);
		String filesInDirectory[] = directory.list();
		
		for(String f:filesInDirectory){	
			if(f.endsWith(".pol")){
				directoryFiles.add(GenericReader.getFileContents(f)); // adds the list to the list
			}
		}
	
		return directoryFiles;
	}
	
}
