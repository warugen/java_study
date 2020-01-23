package com.tj.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

public class Ex01 extends JFrame implements ActionListener {
	private Container 	contPane;
	private JPanel 		jpanel;
	private JLabel 		jlabel;
	private JButton 	jbtn;
	public Ex01() {
		this("");
	}
	public Ex01(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// x버튼 클릭시 종료
//		contPane = getContentPane();		// 컨테이너를 받아옴 new 안함
		jpanel = (JPanel)getContentPane();	// 컨테이너를 받아서 jpanel변수에 형변환하여 넣음
		jpanel.setLayout(new FlowLayout());
		jlabel = new JLabel("펭하",(int)CENTER_ALIGNMENT);
		jbtn = new JButton("종료");
		jlabel.setPreferredSize(new Dimension(250, 200));
		jbtn.setPreferredSize(new Dimension(200, 100));
		jpanel.add(jlabel);
		jpanel.add(jbtn);
		pack();	// 화면은 최소한의 사이즈로
		setLocation(300, 100);
		setVisible(true);
		jbtn.addActionListener(this);		// 버튼눌럿을때 이벤트 등록
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtn) {
			setVisible(false);
			dispose();
			System.exit(0);
		}
	}
	
	public static void main(String[] args) {
		new Ex01("안녕하세요");
	}
}
