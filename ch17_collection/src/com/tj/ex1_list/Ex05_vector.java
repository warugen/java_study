package com.tj.ex1_list;

import java.util.Vector;

public class Ex05_vector {
	public static void main(String[] args) {
		Vector<Object> vector = new Vector<Object>();
		vector.add(new AClass());
		vector.add(new BClass());
		vector.add("String");
		
		System.out.println(vector);
		System.out.println("1번 인덱스값 : "+ vector.get(1));
		System.out.println("2번 인덱스값 : "+ vector.elementAt(2));
		
		vector.clear();
		if(vector.isEmpty()) {
			System.out.println("clear!");
		} else {
			System.out.println("noClear");
		}
	}
}
