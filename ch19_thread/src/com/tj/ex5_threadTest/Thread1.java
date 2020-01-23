package com.tj.ex5_threadTest;

public class Thread1 implements Runnable{

	@Override
	public void run() {
		for(int i =0; i<300;i++) {
			System.out.print('-');
		}
	}
}
