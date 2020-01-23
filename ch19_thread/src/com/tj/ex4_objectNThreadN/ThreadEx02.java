package com.tj.ex4_objectNThreadN;

public class ThreadEx02 extends Thread{
	private int num = 0;	// 공유 변수
	@Override
	public void run() {
		for (int i = 0; i < 10; i++) {
			if(Thread.currentThread().getName().equals("A")) {
				System.out.println("~~ ~~ A 쓰레드 실행중 ~~ ~~");
				num++;
			}
			System.out.println(Thread.currentThread().getName()+"의 num = "+ num);
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {}
		}
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	
	
}
