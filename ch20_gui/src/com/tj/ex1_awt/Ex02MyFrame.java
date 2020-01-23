package com.tj.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Ex02MyFrame extends Frame implements ActionListener{
	private Label label;
	private Button btnExit;
	public Ex02MyFrame() {
		this("");
	}
	public Ex02MyFrame(String title) {
		super(title);
		setLayout(new FlowLayout());
//		setLayout(new GridLayout(1, 2));	// 1행 2열짜리 그리드레이아웃
		btnExit = new Button("종 료");
		label = new Label("즐거운 화요일");
//		label.setSize(new Dimension(250, 200));
		label.setPreferredSize(new Dimension(250, 200));
//		btnExit.setSize(new Dimension(200, 200));
		btnExit.setPreferredSize(new Dimension(200, 200));
		add(label);
		add(btnExit);
		setSize(new Dimension(500, 300));
		setVisible(true);
		btnExit.addActionListener(this);	// 버튼 이벤트 처리 리스너
		addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		});
	}
	// 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ex02MyFrame("나의 예제");
	}
}
