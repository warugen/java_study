package com.tj.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex01_hashMap {
	public static void main(String[] args) {
		HashMap<Integer, String> hashmap = new HashMap<Integer, String>();
		hashmap.put(0, "str0");
		hashmap.put(1, "str1");
		hashmap.put(2, "str2");
		hashmap.put(3, "str3");
		
		System.out.println(hashmap.get(2));
		System.out.println("remove 전 : "+hashmap);
		hashmap.remove(2);	
		System.out.println("remove 후 : "+hashmap);
		hashmap.put(2, "str22");
		System.out.println("다시 추가후 : "+hashmap);
		hashmap.clear();
		System.out.println("clear한 후 : "+hashmap);
		hashmap.put(0, "홍길동");
		hashmap.put(1, "김길동");
		hashmap.put(2, "고길동");
		hashmap.put(3, "최길동");
		
		Iterator<Integer> keys = hashmap.keySet().iterator();
		
		while(keys.hasNext()) {
			Integer key = keys.next();
			System.out.println(key + " : "+hashmap.get(key));
		}
	}
	
}
