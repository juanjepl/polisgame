package tests;

import game.Sea;
import java.util.List;
import java.util.Map;

public class TestUtiles {
	
	public static<T> void printList(List<T> list){
		for(T s: list){
			System.out.println(s);
		}
	}
	
	public static<T> void printListToList(List<List<T>> list){
		for(List<T> l: list){
			for(T s: l){
				System.out.println(s);
			}
		}
	}
	
	public static<K,V> void printMap(Map<K,V> map){
		for(K k: map.keySet()){
			System.out.println(k);
		}
		for(V v: map.values()){	
			System.out.println(v);
		}
	}
	
	public static<T> void printMapList(Map<String,List<T>> map){
		for(String s: map.keySet()){
			for(List<T> list: map.values()){	
				for(T s2: list){
					System.out.println(s2);
				}
			}
		}
	}
	

}
