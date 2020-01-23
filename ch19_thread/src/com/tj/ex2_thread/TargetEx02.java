package com.tj.ex2_thread;

public class TargetEx02 extends Thread {
	@Override
	public void run() {
		for(int i=0;i<10;i++) {
			System.out.println("반갑습니다.");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}
}
