package com.tj.ex7_timer;

import java.util.Timer;
import java.util.TimerTask;

public class TimerMain {
	public static void main(String[] args) throws InterruptedException {
		System.out.println("시작");
		
		Timer timer = new Timer(true);	// Timer(true) :프로그램 종료시 timer 메모리 상주하지않는다.
		TimerTaskEx1 task1 = new TimerTaskEx1();
		TimerTaskEx2 task2 = new TimerTaskEx2();
//		TimerTask task1 = new TimerTaskEx1();
//		TimerTask task2 = new TimerTaskEx2();
		
		timer.schedule(task1, 2000);
		timer.schedule(task2, 1000, 500);
		Thread.sleep(11000);
		System.out.println("끄읕");
	}
}
