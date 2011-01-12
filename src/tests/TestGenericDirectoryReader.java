package tests;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Test;

import utils.GenericDirectoryReader;

public class TestGenericDirectoryReader {
	
	List<List<String>> list;
	Map<String,List<String>> map;
	@Before
	public void setup() {
		list = new ArrayList<List<String>>();
		map = new HashMap<String,List<String>>(); 

	}

	@Test
	public void testgetDirectoryFilesVoid(){
		list = GenericDirectoryReader.getDirectoryFilesContents("src/tests/TestFiles/TestVoidDirectory");
		assert(list.isEmpty());
		//TestUtiles.printListToList(list);
	}
	@Test
	public void testgetDirectoryFiles() {
		list = GenericDirectoryReader.getDirectoryFilesContents("src/tests/TestFiles/TestDirectory");
		assertTrue(list.size()==3);
		//TestUtiles.printListToList(list);
	}


	@Test
	public void testgetDirectoryFilesMap() {
		map = GenericDirectoryReader.getDirectoryFilesContentsInAMap("src/tests/TestFiles/TestDirectory");
		//TestUtiles.printMapList(map);
	}


}
