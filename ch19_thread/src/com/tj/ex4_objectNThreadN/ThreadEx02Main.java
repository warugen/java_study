package com.tj.ex4_objectNThreadN;

public class ThreadEx02Main {
	public static void main(String[] args) {
		Thread threadA = new ThreadEx02();
		Thread threadB = new ThreadEx02();
		
		threadA.setName("A");
		threadB.setName("B");
		
		threadA.start();
		threadB.start();
		
		try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {}
		
		System.out.println("main 함수 종료전 A의 num = "+((ThreadEx02)threadA).getNum());
		System.out.println("main 함수 종료전 B의 num = "+((ThreadEx02)threadB).getNum());
		
		System.out.println("main 함수 끝");
	}
}
