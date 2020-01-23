package com.tj.ex3_set;

import java.util.HashSet;

public class Ex01_hashSet {
	public static void main(String[] args) {
		HashSet<String> hash = new HashSet<String>();
		hash.add("str0");
		hash.add("str1");
		hash.add("str2");
		System.out.println(hash.add("str2"));
//		hash.add("str2");
		
		System.out.println(hash.size());
		System.out.println(hash);
	}
}
