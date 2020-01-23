package com.tj.ex2_swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.HashMap;
import java.util.Iterator;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Ex03 extends JFrame implements ActionListener{

	private Container contPane;
	private JPanel jpup, jpdn;
	private JLabel jlblName;
	private JLabel jlblPhone;
	private JLabel jlblAge;
	private JTextField txtName;
	private JTextField txtPhone;
	private JTextField txtAge;
	private ImageIcon img1, img2;
	private JButton btnInput;
	private JButton btnOutput;
	private JTextArea txtArea;
	private JScrollPane scroll;
	private JPanel jpAll;		// (2,0)
	private JPanel jpLeft;		// 왼쪽 라벨 (3,0)
	private JPanel jpRight;		// 오른쪽 텍스트 필드 (3,0)
	private JPanel jpUnit;		// 왼쪽 오른쪽 합친것 (1,2)
	private HashMap<String, Person> person;
	
	public Ex03() {
		this("");
	}
	
	public Ex03(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdn = new JPanel(new FlowLayout());
		txtName = new JTextField(15);
		txtPhone = new JTextField(15);
		txtAge = new JTextField(15);
		img1 = new ImageIcon("icon\\bell.gif");
		img2 = new ImageIcon("icon\\write.gif");
		btnInput = new JButton("입력", img1);
		btnOutput = new JButton("출력", img1);
		txtArea = new JTextArea(5, 30);
		scroll = new JScrollPane(txtArea);
		person = new HashMap<String, Person>();
		//////////////////////////////////////////////
		jpAll = new JPanel(new GridLayout(3, 0));
		jpLeft = new JPanel(new GridLayout(3, 0));
		jpRight = new JPanel(new GridLayout(3, 0));
		jpUnit = new JPanel(new GridLayout(1, 2));
		jpLeft.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		jpLeft.add(new JLabel("전화", (int)CENTER_ALIGNMENT));
		jpLeft.add(new JLabel("나이", (int)CENTER_ALIGNMENT));
		jpRight.add(txtName);
		jpRight.add(txtPhone);
		jpRight.add(txtAge);
		jpUnit.add(jpLeft);
		jpUnit.add(jpRight);
		//////////////////////////////////////////////
		
//		jpup.add(new JLabel("이름",(int)CENTER_ALIGNMENT);
//		jpup.add(txtName);
//		jpup.add(new JLabel("전화",(int)CENTER_ALIGNMENT);
//		jpup.add(txtPhone);
//		jpup.add(new JLabel("나이",(int)CENTER_ALIGNMENT);
//		jpup.add(txtAge);
		
		jpdn.add(btnInput);
		jpdn.add(btnOutput);
		jpAll.add(jpUnit);
		jpAll.add(jpdn);
		jpAll.add(scroll);
		contPane.add(jpAll);
//		contPane.add(jpup);
//		contPane.add(jpdn);
//		contPane.add(scroll);
		
		setVisible(true);
//		setSize(new Dimension(200, 400));
//		setLocation(300, 100);
		setBounds(300, 100, 400, 350);
		btnInput.addActionListener(this);
		btnOutput.addActionListener(this);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == btnInput) {
			// 이름 나이 전화번호 를 person에 추가
			String name = txtName.getText().trim();
			String phone = txtPhone.getText().trim();
			int age = 0;
			try {
				age = Integer.parseInt(txtAge.getText().trim());		
			} catch (NumberFormatException e2) {
				JOptionPane.showMessageDialog(contPane, "올바른 나이값을 입력해주세요");
				txtArea.setText("나이의 타입이 유효하지 않아 입력 실패");
				return;
			}
			if(name.equals("") || phone.equals("")) {
				JOptionPane.showMessageDialog(contPane, "이름과 전화번호를 입력하지 않아 입력 실패");
				txtArea.setText("이름과 전화번호를 입력하지 않아 입력 실패");
				return;
			}
			if(age>150 || age <0) {
				JOptionPane.showMessageDialog(contPane, "유효하지 않은 나이는 입력 실패");
				txtArea.setText("유효하지 않은 나이는 입력 실패");
				return;
			}
			// person(hashmap)에 같은 전화번호가 있는지 체크
			int idx = 0;	// 전화번호가 있는지 확인용 있으면 숫자 올라가기
			Iterator<String> iterator = person.keySet().iterator();
			while(iterator.hasNext()) {
				String tmp = iterator.next();
				if( phone.equals(tmp)) {
					
					break;
				} 
				idx++;
			}
			
			if(idx < person.size()) {
				JOptionPane.showMessageDialog(contPane, "중복된 전화 번호가 있어 입력 실패");
				txtArea.setText("중복된 전화 번호가 있어 입력 실패");
				return;
			}
			
			// person <HashMap>에 추가
			Person p = new Person(name, phone, age);
			person.put(phone, p);
			txtArea.setText(p.toString()+"입력성공");
			txtName.setText("");
			txtPhone.setText("");
			txtAge.setText("");
		} else if ( e.getSource() == btnOutput) {
			// person을 파일 출력과 콘솔창에 출력
			Writer writer = null;
			try {
				writer = new FileWriter("src/com/tj/ex2_swing/person.txt");
				Iterator<String> itr = person.keySet().iterator();
				txtArea.setText(""); 
				while(itr.hasNext()) {
					String key = itr.next();
					Person p = person.get(key);
					System.out.println(p);			// 콘솔 출력
					txtArea.append(p.toString());	// 텍스트에리어 출력
					writer.write(p.toString());		// 파일 출력
				}
				System.out.println(person.size()+"명 입력");	// 몇명 입력했는지 출력
				txtArea.append(person.size()+"명 입력");
				writer.write(person.size()+"명 입력");
				JOptionPane.showMessageDialog(contPane, person.size()+"명 person.txt 파일로 저장되었습니다.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(writer!=null)
					writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
	}
	public static void main(String[] args) {
		new Ex03("GUI 예제");
	}
}
