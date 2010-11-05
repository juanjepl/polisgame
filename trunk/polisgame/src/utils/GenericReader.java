package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class GenericReader {

	public GenericReader(){}
	
	// This static method returns file contents into a List
	
	public static List<String> getFileContents(String filename)
	{
		List<String> fileContents = new ArrayList<String>();
		
		File file = null;
	    FileReader fr = null;
	    BufferedReader br = null;

	    try {
			
			file = new File(filename);
			fr = new FileReader(file);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null)
				
				if(line.startsWith("#"))
				{
					continue;
				}
				
				fileContents.add(line);
				
	    } 
	    
	    catch (Exception e) {
	    	e.printStackTrace();
		} 
	    
	    finally {
			
			try {
				if (null != fr) {
					fr.close();
				}
			} catch (Exception e2) {
				e2.printStackTrace();
			}
		}
		
		return fileContents;
	}
}
