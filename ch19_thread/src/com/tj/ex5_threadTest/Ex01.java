package com.tj.ex5_threadTest;

public class Ex01 {
	public static void main(String[] args) {
		Runnable target = new Thread1();
		Thread th1 = new Thread(target,"A");
		th1.start();
		for (int i = 0; i < 300; i++) {
			System.out.print("★");
		}
	}
}
