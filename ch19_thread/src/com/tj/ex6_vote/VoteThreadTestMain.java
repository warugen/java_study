package com.tj.ex6_vote;

public class VoteThreadTestMain {
	public static void main(String[] args) {
		Thread location1 = new VoteThread("A지역");
		Thread location2 = new VoteThread("B지역");
		Thread location3 = new VoteThread("C지역");
		
		location1.start();
		location2.start();
		location3.start();
	}
}
