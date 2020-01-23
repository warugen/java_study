package com.tj.ex4;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.*;

public class StudentMng extends JFrame implements ActionListener{
	
	private Container 	contPane;
	private JPanel		jpup;
	private JPanel		jp1;
	private JPanel		jp2;
	private JTextField	txtHakbun;
	private JTextField	txtName;
	private JTextField	txtScore;
	private JComboBox<String> comMajor;
	private Vector<String>	items;
	private JButton		btnInput;
	private JButton		btnSearch;
	private JButton		btnUpdate;
	private JButton		btnOutput;
	private JButton		btnExpelOutput;
	private JButton		btnExpel;
	private JTextArea	jtaResult;
	private JScrollPane	scroll;
	private HashMap<String, Student> students;
	
	public StudentMng() {
		this("");
	}
	public StudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		students = new HashMap<String, Student>();
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4, 2));
		jp1 = new JPanel(new FlowLayout());
		jp2 = new JPanel(new FlowLayout());
		txtHakbun = new JTextField(15);
		txtName = new JTextField(15);
		txtScore = new JTextField(15);
		items = new Vector<String>();
		items.add("경영정보");
		items.add("건축공학");
		items.add("정보처리");
		items.add("영문");
		comMajor = new JComboBox<String>(items);
		
		btnInput = new JButton("학생입력");
		btnSearch = new JButton("학번조회");
		btnUpdate = new JButton("학생수정");
		btnOutput = new JButton("전체출력");
		btnExpelOutput = new JButton("제적출력");
		btnExpel = new JButton("제적처리");
		
		jtaResult = new JTextArea(13, 30);
		scroll = new JScrollPane(jtaResult);
		
		jpup.add(new JLabel("학번",(int)CENTER_ALIGNMENT));
		jpup.add(txtHakbun);
		jpup.add(new JLabel("이름",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("전공",(int)CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(new JLabel("점수",(int)CENTER_ALIGNMENT));
		jpup.add(txtScore);
		
		jp1.add(btnInput);
		jp1.add(btnSearch);
		jp1.add(btnUpdate);
		
		jp2.add(btnOutput);
		jp2.add(btnExpelOutput);
		jp2.add(btnExpel);
		
		contPane.add(jpup);
		contPane.add(jp1);
		contPane.add(jp2);
		contPane.add(jtaResult);
		
		setVisible(true);
		setBounds(300, 100, 400, 500);
		
		btnInput.addActionListener(this);
		btnSearch.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExpelOutput.addActionListener(this);
		btnExpel.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String 	name;
		String 	hakbun;
		String	major;
		int		score;
		
		if(e.getSource() == btnInput) {
			// 학생입력
			hakbun 	= txtHakbun.getText().trim();
			name 	= txtName.getText().trim();
			major	= comMajor.getSelectedItem().toString().trim();
			jtaResult.setText("");
			if(hakbun.equals("")) {
				System.out.println("학번을 입력해주세요.");
				jtaResult.append("학번을 입력해주세요.");
				return;
			}
			if(name.equals("")) {
				System.out.println("이름을 입력해주세요.");
				jtaResult.append("이름을 입력해주세요.");
				return;
			}
			try {
				score = Integer.parseInt(txtScore.getText().trim());			
			} catch (NumberFormatException e2) {
				jtaResult.append("학점은 정수형식으로만 입력해주세요.");
				return;
			}
			// 같은 학번이 있는지 체크
			boolean fnd = false;
			Iterator<String> iter = students.keySet().iterator();
			while (iter.hasNext()) {
				String tmp = iter.next();
				if(hakbun.equals(tmp)) {
					fnd = true;
					break;
				}
			}
			if (fnd) {
				jtaResult.setText("중복된 학번이 있어서 입력 실패했습니다.");
				JOptionPane.showMessageDialog(contPane, "중복된 학번이 있어서 입력 실패했습니다.");
				return;
			}
			
			Student s = new Student(hakbun, name, major, score);
			students.put(hakbun, s);
			jtaResult.setText(s.toString()+"입력성공");
			JOptionPane.showMessageDialog(contPane, name+"학생 입력성공");
			txtHakbun.setText("");
			txtName.setText("");
			comMajor.setSelectedIndex(0);
			txtScore.setText("");
			
			
		} else if(e.getSource() == btnSearch) {
			// 학번조회
		} else if(e.getSource() == btnUpdate) {
			// 학생수정
		} else if(e.getSource() == btnOutput) {
			// 전체출력
		} else if(e.getSource() == btnExpelOutput) {
			// 제적출력
		} else if(e.getSource() == btnExpel) {
			// 제적처리
		}
		
	}
	
	public static void main(String[] args) {
		new StudentMng("학점관리");
	}
}
