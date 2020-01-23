package com.tj.ex2_thread;

public class TargetMain {
	public static void main(String[] args) {
		Thread threadA = new TargetEx01();	// 쓰레드 생성과 동시에 run()이 이미 정의됨
		Thread threadB = new TargetEx02();
		threadA.setName("A");
		threadB.setName("B");
		
		threadA.start();
		threadB.start();
		
		for(int i =0; i<10; i++) {
//			System.out.println("나는 main 쓰레드");
			System.out.println(Thread.currentThread().getName());
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
