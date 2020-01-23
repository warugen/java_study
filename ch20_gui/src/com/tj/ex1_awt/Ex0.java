package com.tj.ex1_awt;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.Frame;

public class Ex0 {
	public static void main(String[] args) {
		Frame frame = new Frame("Hello, awt!");
		Button btn = new Button("버튼");
		Button btn2 = new Button("버튼2");
		frame.add(btn);
		frame.add(btn2);
		frame.setSize(new Dimension(300, 200));
//		frame.pack();	// 최소한의 창사이즈
		frame.setLocation(100, 50);
		frame.setVisible(true);		// frame을 화면에 보이게
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {}
		
		frame.setVisible(false);	// 화면이 안보이게
		frame.dispose();			// 자원해제
		System.exit(0);				// 강제종료
		
	}
}
