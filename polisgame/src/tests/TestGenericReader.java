package tests;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import utils.GenericReader;

import org.junit.Test;
import org.junit.Before;
import org.junit.After;

public class TestGenericReader {

	List<String> list = new ArrayList<String>();

	@Before
	public void setup() {

	}

	@Test
	public void testgetFileContents() {
		list = GenericReader.getFileContents("./src/TestList.txt");
	}

	@Test
	 public void testgetFileContentsNull(){	
		list = GenericReader.getFileContents("./src/TestListNull.txt");
			
	 }


}
