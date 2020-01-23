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
		items.add("�濵����");
		items.add("�������");
		items.add("����ó��");
		items.add("����");
		comMajor = new JComboBox<String>(items);
		
		btnInput = new JButton("�л��Է�");
		btnSearch = new JButton("�й���ȸ");
		btnUpdate = new JButton("�л�����");
		btnOutput = new JButton("��ü���");
		btnExpelOutput = new JButton("�������");
		btnExpel = new JButton("����ó��");
		
		jtaResult = new JTextArea(13, 30);
		scroll = new JScrollPane(jtaResult);
		
		jpup.add(new JLabel("�й�",(int)CENTER_ALIGNMENT));
		jpup.add(txtHakbun);
		jpup.add(new JLabel("�̸�",(int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("����",(int)CENTER_ALIGNMENT));
		jpup.add(comMajor);
		jpup.add(new JLabel("����",(int)CENTER_ALIGNMENT));
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
			// �л��Է�
			hakbun 	= txtHakbun.getText().trim();
			name 	= txtName.getText().trim();
			major	= comMajor.getSelectedItem().toString().trim();
			jtaResult.setText("");
			if(hakbun.equals("")) {
				System.out.println("�й��� �Է����ּ���.");
				jtaResult.append("�й��� �Է����ּ���.");
				return;
			}
			if(name.equals("")) {
				System.out.println("�̸��� �Է����ּ���.");
				jtaResult.append("�̸��� �Է����ּ���.");
				return;
			}
			try {
				score = Integer.parseInt(txtScore.getText().trim());			
			} catch (NumberFormatException e2) {
				jtaResult.append("������ �����������θ� �Է����ּ���.");
				return;
			}
			// ���� �й��� �ִ��� üũ
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
				jtaResult.setText("�ߺ��� �й��� �־ �Է� �����߽��ϴ�.");
				JOptionPane.showMessageDialog(contPane, "�ߺ��� �й��� �־ �Է� �����߽��ϴ�.");
				return;
			}
			
			Student s = new Student(hakbun, name, major, score);
			students.put(hakbun, s);
			jtaResult.setText(s.toString()+"�Է¼���");
			JOptionPane.showMessageDialog(contPane, name+"�л� �Է¼���");
			txtHakbun.setText("");
			txtName.setText("");
			comMajor.setSelectedIndex(0);
			txtScore.setText("");
			
			
		} else if(e.getSource() == btnSearch) {
			// �й���ȸ
		} else if(e.getSource() == btnUpdate) {
			// �л�����
		} else if(e.getSource() == btnOutput) {
			// ��ü���
		} else if(e.getSource() == btnExpelOutput) {
			// �������
		} else if(e.getSource() == btnExpel) {
			// ����ó��
		}
		
	}
	
	public static void main(String[] args) {
		new StudentMng("��������");
	}
}
