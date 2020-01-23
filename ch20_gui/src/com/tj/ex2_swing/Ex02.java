package com.tj.ex2_swing;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.*;

public class Ex02 extends JFrame implements ActionListener{
	
	private Container 	contPane;
	private JLabel		jlbl;
	private JButton		jbtn;
	private JButton		jbtnExit;
	private JTextField	jtxtfd;
	private JComboBox<String> jcombo;
	private Vector<String>	items;
	private String[] item = {"A","B","C"};
	private JCheckBox	jchk;
	private JLabel		jlblBlank;		// 빈 라벨
	public Ex02() {
		this("");
	}
	public Ex02(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);	// x버튼 클릭시 종료
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jlbl = new JLabel("라벨");
		jbtn = new JButton("Button");
		jtxtfd = new JTextField();
		items = new Vector<String>();		// 콤보박스에 들어갈 항목들을 vector에
		items.add("A");
		items.add("B");
		items.add("C");
		jcombo = new JComboBox<String>(items);		// 콤보박스에 백터넣기
//		jcombo = new JComboBox<String>(item);		// 콤보박스에 String배열 넣기
		jchk = new JCheckBox("checkbox");
		jlblBlank = new JLabel();
		jbtnExit = new JButton("종료");
		contPane.add(jlbl);
		contPane.add(jbtn);
		contPane.add(jtxtfd);
		contPane.add(jcombo);
		contPane.add(jchk);
		contPane.add(jlblBlank);
		contPane.add(jbtnExit);
		
		jlbl.setPreferredSize(new Dimension(50, 50));
		jbtn.setPreferredSize(new Dimension(100, 50));
		jtxtfd.setPreferredSize(new Dimension(300, 50));
		jcombo.setPreferredSize(new Dimension(100, 50));
		jchk.setPreferredSize(new Dimension(100, 50));
		jlblBlank.setPreferredSize(new Dimension(200, 50));
		jbtnExit.setPreferredSize(new Dimension(100, 50));
		
		setVisible(true);
		pack();
		setLocation(300, 100);
		jbtn.addActionListener(this);
		jbtnExit.addActionListener(this);
		jcombo.addActionListener(this);
		jchk.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == jbtnExit) {
			int answer = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
			if(answer == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
			
		} else if (e.getSource() == jbtn) {
			// 텍스트필드값을 jcombo에 추가하고 jlblblank에도 나타나게
			String str = jtxtfd.getText().trim();
//			if(str.equals("")) return;
			if(str.equals("")) {
				JOptionPane.showMessageDialog(contPane, "입력한값이 없습니다.");
				jlblBlank.setText("입력한 값이 없습니다.");
				jtxtfd.setText("");
			} 
			if(!str.equals("")) {
				jcombo.addItem(str);
				jlblBlank.setText(str);
				jtxtfd.setText("");
			}
		} else if (e.getSource() == jcombo) {
			// 콤보에 선택된 항목을 jlblblank에 나타나게
			jlblBlank.setText(jcombo.getSelectedItem().toString());
		} else if (e.getSource() == jchk) {
			// 체크되면 jlblblank에 체크됬다고, 체크되지 않으면 안됬다고
			if(jchk.isSelected()) {
				jlblBlank.setText("체크되었습니다.");
			}else{
				jlblBlank.setText("체크해제되었습니다.");
			}
		}
	}
	public static void main(String[] args) {
		new Ex02();
	}
}
