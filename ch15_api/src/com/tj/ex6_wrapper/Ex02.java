package com.tj.ex6_wrapper;

import com.tj.ex4_object.Card;

public class Ex02 {
	public static void main(String[] args) {
		Integer obj1 = 10;
		Integer obj2 = 10;
		int total = obj1 + obj2;
		System.out.println(total);
		
		Card c = new Card('♥', 9);
		
		System.out.println(c.equals(obj1));
		int i=10;
		boolean b = true;
		Boolean bobj = true;	// new Boolean(true);
		System.out.println(c.equals(i));
		
	}
}
