package com.tj.student;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.*;

public class SwingStudentMng extends JFrame implements ActionListener {
	private Container	contenPane;
	private JPanel		jpup, jpbtn;
	private JTextField	txtSNo;
	private JTextField	txtSName;
	private JTextField	txtScore;
	private Vector<String> mNames;	// 콤보박스에들어갈 전공리스트를 저장할 벡터
	private JComboBox<String> comMname;
	private JButton		btnSNoSearch;
	private JButton		btnSNameSearch;
	private JButton		btnMNameSearch;
	private JButton		btnInput;
	private JButton		btnUpdate;
	private JButton		btnStudentOut;
	private JButton		btnExpel;
	private JButton		btnExit;
	private JButton		btnExpelOut;
	private JTextArea	txtPool;
	private JScrollPane	scrollPane;
	
	private ArrayList<StudentDTO> students;
	private ArrayList<StudentSelectDTO> nameStudents;
	
	private String 				driver;
	private String 				url;
	private Connection 			conn;
	private PreparedStatement 	pstmt;
	private ResultSet 			rs;
	
	public SwingStudentMng() {
		this("");
	}
	
	public SwingStudentMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		students = new ArrayList<StudentDTO>();
		nameStudents = new ArrayList<StudentSelectDTO>();
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		contenPane = getContentPane();
		contenPane.setLayout(new FlowLayout());
		jpup = new JPanel(new GridLayout(4,3));
		jpbtn = new JPanel(new FlowLayout());
		txtSNo = new JTextField(15);
		txtSName = new JTextField(15);
		txtScore = new JTextField(15);
		mNames = new Vector<String>();
		mNames.add("");
		comMname = new JComboBox<String>(mNames);
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement("SELECT MNAME FROM MAJOR");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				mNames.add(rs.getString(1));
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB error");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL error");
		} finally {
			try {
				if(rs != null) rs.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
		btnSNoSearch = new JButton("학번검색");
		btnSNameSearch = new JButton("이름검색");
		btnMNameSearch = new JButton("전공검색");
		
		btnInput = new JButton("학생입력");
		btnUpdate = new JButton("학생수정");
		btnStudentOut = new JButton("학생출력");
		btnExpel = new JButton("재적처리");
		btnExpelOut = new JButton("재적출력");
		btnExit = new JButton("종료");
		
		txtPool = new JTextArea(15, 45);
		scrollPane = new JScrollPane(txtPool);
		
		jpup.add(new JLabel("학번", (int)CENTER_ALIGNMENT));
		jpup.add(txtSNo);
		jpup.add(btnSNoSearch);
		
		jpup.add(new JLabel("이름", (int)CENTER_ALIGNMENT));
		jpup.add(txtSName);
		jpup.add(btnSNameSearch);
		
		jpup.add(new JLabel("전공", (int)CENTER_ALIGNMENT));
		jpup.add(comMname);
		jpup.add(btnMNameSearch);
		
		jpup.add(new JLabel("점수", (int)CENTER_ALIGNMENT));
		jpup.add(txtScore);
		
		jpbtn.add(btnInput);
		jpbtn.add(btnUpdate);
		jpbtn.add(btnStudentOut);
		jpbtn.add(btnExpel);
		jpbtn.add(btnExpelOut);
		jpbtn.add(btnExit);
		
		contenPane.add(jpup);
		contenPane.add(jpbtn);
		contenPane.add(txtPool);
		
		setVisible(true);
		setBounds(300, 100, 550, 500);
		setResizable(false);
		
		btnSNoSearch.addActionListener(this);
		btnSNameSearch.addActionListener(this);
		btnMNameSearch.addActionListener(this);
		btnInput.addActionListener(this);
		btnUpdate.addActionListener(this);
		btnStudentOut.addActionListener(this);
		btnExpel.addActionListener(this);
		btnExpelOut.addActionListener(this);
		btnExit.addActionListener(this);
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		String sno = "";
		String sname = "";
		String mname = "";
		String stscore = "";
		int	   rank = 0;
		int    score = 0;
		String sql = "";
		
		if(e.getSource() == btnSNoSearch) {
			// 학번검색
			sno = txtSNo.getText().trim();
			txtPool.setText("");
			
			if(sno.equals("")) {
				txtPool.setText("학번을 입력해주세요");
				JOptionPane.showMessageDialog(contenPane, "학번을 입력해주세요");
				return;
			}
			
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			sql = "SELECT * " + 
					"FROM STUDENT S, MAJOR M " + 
					"WHERE S.MNO = M.MNO AND SNO = ?";
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sno);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					
					txtSNo.setText(sno);
					txtSName.setText(rs.getString("sname"));
					comMname.setSelectedIndex(rs.getInt("mno"));
					txtScore.setText(String.format("%d", rs.getInt("score")));
				} else {
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
					txtPool.setText("해당학번 학생을 찿을 수가 없습니다.");
					JOptionPane.showMessageDialog(contenPane, "해당학번 학생을 찿을 수가 없습니다.");
					return;
				}
				
			} catch (ClassNotFoundException e2) {
				System.out.println(e2.getMessage() + "DB error");
			} catch (SQLException e2) {
				System.out.println(e2.getMessage() + "SQL error");
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
		} else if (e.getSource() == btnSNameSearch) {
			// 이름검색
			sname = txtSName.getText().trim();
			txtPool.setText("");
			
			if(sname.equals("")) {
				txtPool.setText("이름을 입력해주세요");
				JOptionPane.showMessageDialog(contenPane, "이름을 입력해주세요");
				return;
			}
			
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "SELECT * " + 
					"FROM STUDENT S, MAJOR M " + 
					"WHERE S.MNO = M.MNO AND SNAME = ?";
			nameStudents.clear();
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sname);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {

					txtSNo.setText(rs.getString("sno"));
					txtSName.setText(rs.getString("sname"));
					comMname.setSelectedIndex(rs.getInt("mno"));
					txtScore.setText(String.format("%d", rs.getInt("score")));
					
					nameStudents.add(new StudentSelectDTO(rs.getString("sno"), rs.getString("sname"), rs.getString("mname"), rs.getInt("score")));
				}	
				
				if(nameStudents.size() == 0) {
					txtSNo.setText("");
					txtSName.setText("");
					comMname.setSelectedIndex(0);
					txtScore.setText("");
					txtPool.setText("해당 이름의 학생을 찿을 수가 없습니다.");
					JOptionPane.showMessageDialog(contenPane, "해당 이름의 학생을 찿을 수가 없습니다.");
					return;
				} else if (nameStudents.size() > 1) {
					txtPool.setText("학번\t 이름\t 학과\t 점수 \n");
					txtPool.append("------------------------------------------------------------------------\n");
					
					for(StudentSelectDTO s : nameStudents) {
						txtPool.append(s.toString()+"\n");
					}
					
				}
				
			} catch (ClassNotFoundException e2) {
				System.out.println(e2.getMessage() + "DB error");
			} catch (SQLException e2) {
				System.out.println(e2.getMessage() + "SQL error");
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
		} else if (e.getSource() == btnMNameSearch) {
			// 전공검색
			mname = comMname.getSelectedItem().toString();
			
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE " + 
					"FROM (SELECT SNO, SNAME, MNAME, S.MNO, SCORE FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND mNAME = ? ORDER BY SCORE DESC)";
			students.clear();
			
			if (mname.equals("")) {
				txtPool.setText("전공을 선택해주세요.");
				JOptionPane.showMessageDialog(contenPane, "전공을 선택해주세요.");
				return;
			}
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mname);
				
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					rank = rs.getInt(1);
					sname = rs.getString(2);
					mname = rs.getString(3);
					score = rs.getInt(4);
					
					students.add(new StudentDTO(rank, sname, mname, score));
				}
				
				txtPool.setText("등수\t 이름\t\t 학과\t 점수 \n");
				txtPool.append("------------------------------------------------------------------------------------------------\n");
				
				for(StudentDTO s : students) {
					txtPool.append(s.toString()+"\n");
				}
				
			} catch (ClassNotFoundException e2) {
				System.out.println(e2.getMessage() + "DB error");
			} catch (SQLException e2) {
				System.out.println(e2.getMessage() + "SQL error");
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == btnInput) {
			// 학생입력
			sname = txtSName.getText().trim();
			mname = comMname.getSelectedItem().toString().trim();
			stscore = txtScore.getText().trim();
			
			if (sname.equals("")) {
				txtPool.setText("이름을 입력해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "이름을 입력해 주세요.");
				return;
			}
			
			if (mname.equals("")) {
				txtPool.setText("전공을 선택해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "전공을 선택해 주세요.");
				return;
			}
			
			if (stscore.equals("")) {
				txtPool.setText("점수를 입력해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "점수를 입력해 주세요.");
				return;
			}
			
			
			try {
				score = Integer.parseInt(stscore);
				if(score <=0 || score >100) {
					JOptionPane.showMessageDialog(contenPane, "점수 입력범위를 넘어서서 0점으로 입력됩니다.");
					score = 0;
				}
			} catch (Exception e2) {
				txtPool.setText("");
				JOptionPane.showMessageDialog(contenPane, "숫자로 입력해주세요.");
				return;
			}
			
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "INSERT INTO STUDENT (SNO, SNAME, MNO, SCORE) VALUES ( " + 
					"    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = ?) || TRIM(TO_CHAR(STD_SEQ.nextval,'000'))," + 
					"    ?, " + 
					"    (SELECT mNO FROM MAJOR WHERE mNAME = ?), " + 
					"    ?)";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, mname);
				pstmt.setString(2, sname);
				pstmt.setString(3, mname);
				pstmt.setInt(4, score);
				
				int result = pstmt.executeUpdate();
				
				txtPool.setText(result > 0? "학생입력성공":"학생입력실패");
				JOptionPane.showMessageDialog(contenPane, result > 0? "학생입력성공":"학생입력실패");
				
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				
			} catch (ClassNotFoundException e2) {
				System.out.println(e2.getMessage() + "DB error");
			} catch (SQLException e2) {
				System.out.println(e2.getMessage() + "SQL error");
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == btnUpdate) {
			// 학생수정
			sno = txtSNo.getText().trim();
			sname = txtSName.getText().trim();
			mname = comMname.getSelectedItem().toString().trim();
			stscore = txtScore.getText().trim();
			score = 0;
			
			if (sno.equals("")) {
				txtPool.setText("학번을 입력해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "학번을 입력해 주세요.");
				return;
			}
			
			if (sname.equals("")) {
				txtPool.setText("이름을 입력해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "이름을 입력해 주세요.");
				return;
			}
			
			if (mname.equals("")) {
				txtPool.setText("전공을 선택해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "전공을 선택해 주세요.");
				return;
			}
			
			if (stscore.equals("")) {
				txtPool.setText("점수를 입력해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "점수를 입력해 주세요.");
				return;
			}
			
			
			try {
				score = Integer.parseInt(stscore);
				if(score <=0 || score >100) {
					JOptionPane.showMessageDialog(contenPane, "점수 입력범위를 넘어서서 0점으로 입력됩니다.");
					score = 0;
				}
			} catch (Exception e2) {
				txtPool.setText("숫자로 입력해주세요.");
				JOptionPane.showMessageDialog(contenPane, "숫자로 입력해주세요.");
				return;
			}
			
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "UPDATE STUDENT SET  SNAME = ?, " + 
					"                    MNO = (SELECT MNO FROM MAJOR WHERE MNAME = ?), " + 
					"                    SCORE = ?" + 
					"WHERE SNO = ?";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sname);
				pstmt.setString(2, mname);
				pstmt.setInt(3, score);
				pstmt.setString(4, sno);
				
				int result = pstmt.executeUpdate();
				
				txtPool.setText(result > 0? "학생수정성공":"학생수정실패");
				JOptionPane.showMessageDialog(contenPane, result > 0? "학생수정성공":"학생수정실패");
				
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				
			} catch (ClassNotFoundException e2) {
				System.out.println(e2.getMessage() + "DB error");
			} catch (SQLException e2) {
				System.out.println(e2.getMessage() + "SQL error");
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == btnStudentOut) {
			// 전체학생출력
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE " + 
					"FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND SEXPEL = 0 ORDER BY SCORE DESC)";
			
			students.clear();
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);		
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					rank = rs.getInt(1);
					sname = rs.getString(2);
					mname = rs.getString(3);
					score = rs.getInt(4);
					
					students.add(new StudentDTO(rank, sname, mname, score));
				}
				
				if(!students.isEmpty()) {
					txtPool.setText("등수\t 이름\t\t 학과\t 점수 \n");
					txtPool.append("------------------------------------------------------------------------------------------------\n");
					
					for(StudentDTO s : students) {
						txtPool.append(s.toString()+"\n");
					}
				} else {
					txtPool.setText("학생 데이터가 없습니다.");
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == btnExpel) {
			// 재적처리
			sno = txtSNo.getText().trim();
			
			if (sno.equals("")) {
				txtPool.setText("학번을 입력해 주세요.");
				JOptionPane.showMessageDialog(contenPane, "학번을 입력해 주세요.");
				return;
			}
			
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "UPDATE STUDENT SET SEXPEL = 1 WHERE SNO = ?";
			
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, sno);
				
				int result = pstmt.executeUpdate();
				
				txtPool.setText(result > 0? "재적처리성공":"재적처리실패");
				JOptionPane.showMessageDialog(contenPane, result > 0? "재적처리성공":"재적처리실패");
				
				txtSNo.setText("");
				txtSName.setText("");
				comMname.setSelectedIndex(0);
				txtScore.setText("");
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == btnExpelOut) {
			// 재적자출력
			driver = "oracle.jdbc.driver.OracleDriver";
			url = "jdbc:oracle:thin:@localhost:1521:xe";
			
			sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME||'('||MNO||')' MNAME_NO , SCORE " + 
					"FROM (SELECT S.*, MNAME FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND SEXPEL = 1 ORDER BY SCORE DESC)";
			
			students.clear();
			try {
				Class.forName(driver);
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);		
				rs = pstmt.executeQuery();
				
				while (rs.next()) {
					rank = rs.getInt(1);
					sname = rs.getString(2);
					mname = rs.getString(3);
					score = rs.getInt(4);
					
					students.add(new StudentDTO(rank, sname, mname, score));
				}
				
				if(students.size() == 0) {
					txtPool.setText("재적된 학생이 없습니다.");
				} else {
					txtPool.setText("등수\t 이름\t\t 학과\t 점수 \n");
					txtPool.append("------------------------------------------------------------------------------------------------\n");
					
					for(StudentDTO s : students) {
						txtPool.append(s.toString()+"\n");
					}
				}
				
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(rs != null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == btnExit) {
			// 종료버튼
			int answer = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
			if(answer == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
	}
	
	
	public static void main(String[] args) {
		new SwingStudentMng("학생관리");
	}
}
