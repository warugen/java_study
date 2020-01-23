package com.tj.ex7_synchronized;
// Thread N개에 객체 1개 공유
public class ThreadEx implements Runnable{
	private int num = 0;	// 공유 변수
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			out();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	
	private synchronized void out() {
		if(Thread.currentThread().getName().equals("A")) {
			System.out.println("~~ ~~ A 쓰레드 실행중 ~~ ~~");
			num++;
		}
		System.out.println(Thread.currentThread().getName()+"의 num = "+ num);
		
	}
}
