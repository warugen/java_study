package com.tj.ex2_map;

import java.util.HashMap;
import java.util.Iterator;

public class Ex02_hashmap {
	public static void main(String[] args) {
		HashMap<String, String> hash = new HashMap<String, String>();
		hash.put("홍길동", "010-9999-9999");
		hash.put("최민식", "010-8888-5555");
		hash.put("한석규", "010-7777-6666");
		
		System.out.println(hash);
		
		Iterator<String> iter = hash.keySet().iterator();
		
		while (iter.hasNext()) {
			String key = iter.next();
			System.out.println(key + ": "+hash.get(key));
		}
	}
}
