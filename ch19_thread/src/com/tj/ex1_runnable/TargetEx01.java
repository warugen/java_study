package com.tj.ex1_runnable;
// "안녕하세요 10번"하는 Target정의
public class TargetEx01 implements Runnable{

	@Override
	public void run() {
		
		for(int i=0;i<10;i++) {
			System.out.println("안녕하세요.");
			try { // 현재 작업을 0.5초 대기상태로
				Thread.sleep(500);
			} catch (InterruptedException e) {
				System.out.println(e.getMessage());
			}
		}
	}

}
