package com.tj.ex6_vote;

public class VoteTargetTestMain {
	public static void main(String[] args) {
		Runnable target1 = new VoteTarget();
		Runnable target2 = new VoteTarget();
		Runnable target3 = new VoteTarget();
		
		Thread locationA = new Thread(target1, "A지역");
		Thread locationB = new Thread(target2, "B지역");
		Thread locationC = new Thread(target3, "C지역");
		
		locationA.start();
		locationB.start();
		locationC.start();
	}
}
