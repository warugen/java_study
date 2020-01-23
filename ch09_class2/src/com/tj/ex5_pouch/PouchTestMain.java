package com.tj.ex5_pouch;

public class PouchTestMain {
	public static void main(String[] args) {
		System.out.println("엄마 지갑 돈 : " + Child.momPouch.money);
		
		Child first  = new Child("첫째길동이");
		Child second = new Child("둘째똘망이");
		Child third  = new Child("샛째똘순이");
		
		first.takeMoney(100);
		second.takeMoney(100);
		third.takeMoney(100);
		
		System.out.println("엄마 지갑 돈 : " + Child.momPouch.money);
	}
}
