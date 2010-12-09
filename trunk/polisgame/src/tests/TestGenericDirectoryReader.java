package tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;

import utils.GenericDirectoryReader;
import utils.GenericReader;

public class TestGenericDirectoryReader {
	
	List<List<String>> list;
	Map<String,List<String>> map;
	@Before
	public void setup() {
		list = new ArrayList<List<String>>();
		map = new HashMap<String,List<String>>(); 

	}

	@Test//(expected=FileNotFoundException.class)
	public void testgetDirectoryFilesVoid(){
		list = GenericDirectoryReader.getDirectoryFiles("src/tests/TestFiles/TestVoidDirectory");
		assertEquals(list,null);
		//TestUtiles.printListToList(list);
	}
	@Test
	public void testgetDirectoryFiles() {
		list = GenericDirectoryReader.getDirectoryFiles("src/tests/TestFiles/TestDirectory");
		assertTrue(list.contains("TestList.pol"));
		assertTrue(list.contains("TestListNull.pol"));
		assertTrue(list.contains("TestListSharp.pol"));
		//TestUtiles.printListToList(list);
	}


	
	@Test
	public void testgetDirectoryFilesMap() {
		map = GenericDirectoryReader.getDirectoryFilesMap("src/tests/TestFiles/TestDirectory");
		//TestUtiles.printMapList(map);
	}
	


}
