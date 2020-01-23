package com.tj.ex3_homework;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Homework extends JFrame implements ActionListener{
	
	private final static int POINT = 1000;		// 가입용 포인트
	private Container 	contPane;
	private JPanel 		jpup, jpdown;
	private JTextField 	txtPhone;
	private JTextField 	txtName;
	private JTextField 	txtPoint;
	private JButton		btnJoin;
	private JButton		btnSearch;
	private JButton		btnOutput;
	private JButton		btnExit;
	private JTextArea	jta;
	private JScrollPane scroll;
	private ArrayList<Customer> customer;
	
	public Homework() {
		this("");
	}
	public Homework(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		customer = new ArrayList<Customer>();
		contPane = getContentPane();
		contPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(3, 2));
		jpdown = new JPanel(new FlowLayout());
		txtName = new JTextField(15);
		txtPhone = new JTextField(15);
		txtPoint = new JTextField(15);
		txtPoint.setText(String.valueOf(POINT));
		txtPoint.setFocusable(false);
		
		btnJoin = new JButton("가입");
		btnSearch = new JButton("폰조회");
		btnOutput = new JButton("출력");
		btnExit = new JButton("종료");
		
		jta = new JTextArea(15, 30);
		scroll = new JScrollPane(jta);
		
		jpup.add(new JLabel("폰번호", (int)CENTER_ALIGNMENT));
		jpup.add(txtPhone);
		jpup.add(new JLabel("이  름", (int)CENTER_ALIGNMENT));
		jpup.add(txtName);
		jpup.add(new JLabel("포인트", (int)CENTER_ALIGNMENT));
		jpup.add(txtPoint);
		
		jpdown.add(btnJoin);
		jpdown.add(btnSearch);
		jpdown.add(btnOutput);
		jpdown.add(btnExit);
		
		contPane.add(jpup);
		contPane.add(jpdown);
		contPane.add(jta);
		
		setVisible(true);
		setBounds(300, 100, 400, 450);
		setResizable(false);
		btnJoin.addActionListener(this);
		btnSearch.addActionListener(this);
		btnOutput.addActionListener(this);
		btnExit.addActionListener(this);
		
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String name;
		String phone;
		if(e.getSource() == btnJoin) {
			// 가입처리
			name = txtName.getText().trim();
			phone = txtPhone.getText().trim();
			
			if(phone.equals("")) {
				System.out.println("전화번호를 입력해주세요.");
				jta.setText("전화번호를 입력해주세요.");
				JOptionPane.showMessageDialog(contPane, "전화번호를 입력해주세요.");
				return;
			}
			
			if ( phone.length() < 11 || phone.length() > 14 || phone.indexOf('-') == phone.lastIndexOf('-') || (phone.substring(phone.indexOf('-')+1, phone.lastIndexOf('-')).length()<3)) {
				System.out.println("전화번호 형식이 틀렸습니다. 다시 입력해 주세요.");
				jta.setText("전화번호 형식이 틀렸습니다. 다시 입력해 주세요.");
				JOptionPane.showMessageDialog(contPane, "전화번호 형식이 틀렸습니다. 다시 입력해 주세요.");
				return;
			}

			if(name.equals("")) {
				System.out.println("이름을 입력해주세요.");
				jta.setText("이름을 입력해주세요.");
				JOptionPane.showMessageDialog(contPane, "이름을 입력해주세요.");
				return;
			}
			
			Customer c = new Customer(name, phone, POINT);
			customer.add(c);
			jta.setText(c.toString()+"가입 성공");
			txtPhone.setText("");
			txtName.setText("");
			txtPoint.setText(String.valueOf(POINT));
			
		} else if (e.getSource() == btnSearch) {
			// 조회처리
			phone = txtPhone.getText().trim();
			if(phone.equals("")) {
				System.out.println("조회할 번호를 입력해 주세요.");
				jta.setText("조회할 번호를 입력해 주세요.");
				JOptionPane.showMessageDialog(contPane, "조회할 번호를 입력해 주세요.");
				return;
			}
			
			if (phone.length() < 4) {
				System.out.println("뒷 번호는 4자리수로 입력해주세요.");
				jta.setText("뒷 번호는 4자리수로 입력해주세요.");
				JOptionPane.showMessageDialog(contPane, "4자리 수로 입력해 주세요.");
				return;
			}
			
			jta.setText("");
			for(int i = 0; i<customer.size();i++) {
				String tmp = customer.get(i).getPhone();
				String tmpLast = tmp.substring(tmp.lastIndexOf('-')+1);
				if(phone.equals(tmpLast)) {		
					System.out.println(customer.get(i));
					txtPhone.setText(customer.get(i).getPhone());
					txtName.setText(customer.get(i).getName());
					txtPoint.setText(String.valueOf(customer.get(i).getPoint()));
					jta.append(customer.get(i).toString());
				}
			}
			if(jta.getText().equals("")) {
				jta.setText("찿는 회원이 없습니다.");
				txtPhone.setText("");
				txtName.setText("");
				JOptionPane.showMessageDialog(contPane, "찿는 회원이 없습니다.");
			}
		} else if (e.getSource() == btnOutput) {
			// 출력처리
			Writer writer = null;
			if ( customer.size() == 0) {
				System.out.println("출력할 데이터가 없습니다.");
				txtPhone.setText("");
				txtName.setText("");
				jta.setText("");
				jta.append("출력할 데이터가 없습니다.");
				JOptionPane.showMessageDialog(contPane, "출력할 데이터가 없습니다.");
				return;
			}
			try {
				writer = new FileWriter("src/com/tj/ex3_homework/customer.txt");
				jta.setText("");
				for(Customer c : customer) {
					System.out.println(c.toString());
					jta.append(c.toString());
					writer.write(c.toString());
				}
				System.out.println(customer.size()+"명 출력되었습니다.");
				jta.append(customer.size()+"명 출력되었습니다.");
				writer.write(customer.size()+"명 출력되었습니다.");
				JOptionPane.showMessageDialog(contPane, "customer.txt파일 생성완료.");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(writer!=null) writer.close();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else if (e.getSource() == btnExit) {
			// 종료
			int answer = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
			if(answer == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
		
	}

	public static void main(String[] args) {
		new Homework("과제");
	}
}
