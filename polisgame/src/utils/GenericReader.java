package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

/** This class reads the content of a text file */
public class GenericReader {

	public GenericReader(){}
	

	/** This method returns in a List, the file contents, one String per line */
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
			while ((line = br.readLine()) != null){ // TODO white line == null?? test it.
				
				if(line.startsWith("#")){ // ignore line if starts with "#" character. (in order to add some comments in texts)
					continue; // goes to next iteration
				}
				fileContents.add(line);
			} 
	    }
	    catch (Exception e){
	    	e.printStackTrace(); //FIXME modify this exception to best control about it
		} 
	    finally {
			
			try {
				if (null != fr){
					fr.close();  // closes the file.
				}
			} catch (Exception e2){
				e2.printStackTrace();
			}
		}
		return fileContents;
	}
}
