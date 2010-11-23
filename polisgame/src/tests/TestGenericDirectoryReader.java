package tests;

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
	
	List<List<String>> list = new ArrayList<List<String>>();
	Map<String,List<String>> map = new HashMap<String,List<String>>(); 

	@Before
	public void setup() {

	}

	@Test//(expected=FileNotFoundException.class)
	public void testgetDirectoryFilesVoid(){
		list = GenericDirectoryReader.getDirectoryFiles("src/tests/TestFiles/TestVoidDirectory");
		TestUtiles.printListToList(list);
	}
	@Test
	public void testgetDirectoryFiles() {
		list = GenericDirectoryReader.getDirectoryFiles("src/tests/TestFiles/TestDirectory");
		TestUtiles.printListToList(list);
	}

	
//	public void printList(List<List<String>> list){
//		for(List<String> l: list){
//			for(String s: l){
//				System.out.println(s);
//			}
//		}
//	}
	
	@Test
	public void testgetDirectoryFilesMap() {
		map = GenericDirectoryReader.getDirectoryFilesMap("src/tests/TestFiles/TestDirectory");
		TestUtiles.printMapList(map);
	}
	
//	public void printMap(Map<String,List<String>> map){
//		for(String s: map.keySet()){
//			for(List<String> list: map.values()){
//				for(String s2: list){
//					System.out.println(s);
//				}
//			}
//		}
//	}

}
