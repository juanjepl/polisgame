package tests;

import static org.junit.Assert.assertEquals;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

import utils.GenericReader;

import org.junit.Test;
import org.junit.Before;

//import org.junit.After;

public class TestGenericReader {
	
	List<String> list;

	@Before
	public void setup() {
		list = new ArrayList<String>();
	}

	@Test//(expected=FileNotFoundException.class)
	public void testgetFileContentsFailDirectory(){
		list = GenericReader.getFileContents("string");
		//TestUtiles.printList(list);
	}
	@Test
	public void testgetFileContents() {
		list = GenericReader.getFileContents("src/tests/TestFiles/TestList.pol");
		assertEquals(list.get(0),"Hola");
		assertEquals(list.get(1),"Mundo");
		assertEquals(list.get(2),"Ingenieria");
		assertEquals(list.get(3),"Del");
		assertEquals(list.get(4),"Software");
		//TestUtiles.printList(list);
	}

	@Test
	public void testgetFileContentsNull(){
		list = GenericReader.getFileContents("src/tests/TestFIles/TestListNull.pol");
		assertEquals(list.get(0),"Hola");
		assertEquals(list.get(1),"Mundo");
		assertEquals(list.get(2),"Ingenieria");
		assertEquals(list.get(3),"");
		assertEquals(list.get(4),"Del");
		assertEquals(list.get(5),"Software");
		//TestUtiles.printList(list);
	}
	
	@Test
	public void testgetFileContentsSharp(){
		list = GenericReader.getFileContents("src/tests/TestFIles/TestListSharp.pol");
		assertEquals(list.get(0),"Hola");
		assertEquals(list.get(1),"Mundo");
		assertEquals(list.get(2),"Ingenieria");
		assertEquals(list.get(3),"Del");
		assertEquals(list.get(4),"Software");
		//TestUtiles.printList(list);
	}

}
