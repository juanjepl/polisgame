package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * This class reads the content of a text file,
 * returning  a List with one string per line
 */
public class GenericReader {

	public GenericReader(){}
	

	/** This method returns in a List, the file contents, one String per line */
	public static List<String> getFileContents(String filename)
	{
		List<String> fileContents = new ArrayList<String>();
		
	    FileReader fr = null;
	    BufferedReader br = null;

	    try {
			fr = new FileReader(filename);
			br = new BufferedReader(fr);

			String line;
			while ((line = br.readLine()) != null){
				if(line.startsWith("#") || line.startsWith(" ")){ // ignore line if starts with "#" or " " character (# -> for comments)
					continue; // goes to next iteration
				}
				fileContents.add(line);
			} 
	    }
	    catch (IOException e){
	    	e.printStackTrace(); // Exception for opening file fails
		} 
	    finally{
			
			try{
				if(null != fr){
					fr.close();
				}
			}catch(IOException e2){
				e2.printStackTrace(); // Exception for closing file fails
			}
		}
		return fileContents;
	}
}