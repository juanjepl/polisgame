package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.List;
import java.util.ArrayList;

public class TextModeUi {

	public TextModeUi(){}
	
	public static List<String> requestPlayerNames(){
	
	String spartaPlayer = "";	
	String athensPlayer = "";
	
	System.out.print("Sparta player's name: ");
	BufferedReader br_sparta = new BufferedReader(new InputStreamReader(System.in));
	try {
		spartaPlayer = br_sparta.readLine();
	} catch (Exception e) {
		//TODO
	}

	System.out.print("Athens player's name: ");
	BufferedReader br_athens = new BufferedReader(new InputStreamReader(System.in));
	try {
		athensPlayer = br_athens.readLine();
	} catch (Exception e) {	
		//TODO
	}
	
	List<String> twoNames = new ArrayList<String>(2); // 
	twoNames.add(spartaPlayer);
	twoNames.add(athensPlayer);
	return twoNames;
	
	}
	
	public static void loadedGameElements(){
		System.out.println("All Game Elements Loaded . . . . . OK");
	}
	
	public static void loadedStandardStartPosition(){
		System.out.println("Standard Start Position Loaded . . OK");
	}
	
	
}
