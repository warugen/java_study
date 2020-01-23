package com.tj.ex4_objectNThreadN;

public class ThreadEx01Main {
	public static void main(String[] args) {
		Runnable target1 = new ThreadEx01();
		Runnable target2 = new ThreadEx01();
		
		Thread threadA = new Thread(target1,"A");
		Thread threadB = new Thread(target2,"B");
		threadA.start();
		threadB.start();
		System.out.println("main 함수 끝");
	}
}
