package com.tj.ex3_object1ThreadN;

public class ThreadExTestMain {
	public static void main(String[] args) {
		Runnable target = new ThreadEx();
		Thread threadA = new Thread(target, "A");
		Thread threadB = new Thread(target, "B");
		
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
	}
}
