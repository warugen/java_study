package com.tj.ex1_runnable;

public class ThreadExMain {
	public static void main(String[] args) {
		Runnable target = new ThreadEx();
		
		Thread threadA = new Thread(target,"A");
		Thread threadB = new Thread(target,"B");
		threadA.start();
		threadB.start();
		
		System.out.println(Thread.currentThread().getName());
		System.out.println("main함수 끝");
		
	}
}
