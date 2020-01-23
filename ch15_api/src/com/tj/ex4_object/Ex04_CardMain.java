package com.tj.ex4_object;

public class Ex04_CardMain {
	public static void main(String[] args) {
		// ♥♠♣◆ 
		Card c1 = new Card('♥', 7);
		Card c2 = new Card('♥', 7);
		Card c3 = new Card('♠', 2);
		
		// 선택하신 카드는 ♥7
		System.out.println(c1);
		System.out.println(c2);
		System.out.println(c3);
		
		System.out.println("C1과 C2는 같냐? : " + (c1.equals(c2)?"같다":"다르다"));
		System.out.println("C1과 C3는 같냐? : " + (c1.equals(c3)?"같다":"다르다"));
	}
}
