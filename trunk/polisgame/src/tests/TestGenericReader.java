package tests;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import utils.GenericReader;

import org.junit.Test;
import org.junit.Before;

//import org.junit.After;

public class TestGenericReader {

	List<String> list = new ArrayList<String>();

	@Before
	public void setup() {

	}

	@Test//(expected=FileNotFoundException.class)
	public void testgetFileContentsNotString(){
		list = GenericReader.getFileContents("string.txt");
		TestUtiles.printList(list);
	}
	@Test
	public void testgetFileContents() {
		list = GenericReader.getFileContents("src/tests/TestFiles/TestList.txt");
		TestUtiles.printList(list);
	}

	@Test
	public void testgetFileContentsNull() {
		list = GenericReader.getFileContents("src/tests/TestFIles/TestListNull.txt");
		TestUtiles.printList(list);
	}
	
	@Test
	public void testgetFileContentsSharp() {
		list = GenericReader.getFileContents("src/tests/TestFIles/TestListSharp.txt");
		TestUtiles.printList(list);
	}
	
//	public void printList(List<String> list){
//		for(String s: list){
//			System.out.println(s);
//		}
//	}

}
