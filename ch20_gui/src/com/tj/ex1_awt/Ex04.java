package com.tj.ex1_awt;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Ex04 extends Frame implements ActionListener{
	private Panel 		panel;
	private TextField 	txtfd;
	private Button 		btnOK, btnExit;
	private List 		list;
	
	public Ex04() {
		// 컴포넌트 객체 생성
		panel = new Panel(new FlowLayout());
		txtfd = new TextField(20);
		btnOK = new Button("OK");
		btnExit = new Button("EXIT");
		list = new List();
		panel.add(new Label("write"));
		panel.add(txtfd);
		panel.add(btnOK);
		panel.add(btnExit);
		// 적당히 배치
		add(panel,BorderLayout.NORTH);
		add(list,BorderLayout.CENTER);
		setVisible(true);
		setSize(new Dimension(400, 200));
		setLocation(300, 200);
		// 버튼 이벤트 등록
		btnOK.addActionListener(this);
		btnExit.addActionListener(this);
	}
	
	public Ex04(String title) {
		this();
		setTitle(title);
	}

	// 버튼 이벤트 처리
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnExit) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
		
		if(e.getSource() == btnOK) {
			list.add(txtfd.getText());
			txtfd.setText("");
		}
	}
	
	public static void main(String[] args) {
		new Ex04("여러 컴포넌트 예제");
	}
}
