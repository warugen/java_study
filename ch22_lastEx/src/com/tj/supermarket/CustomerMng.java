package com.tj.supermarket;

import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CustomerMng extends JFrame implements ActionListener {
	
	//Swing
	private Container container;
	private JPanel jpup, jpbtn;
	private JTextField jtxtId, jtxtTel, jtxtName, jtxtPoint, jtxtAmount;
	private Vector<String> levels;
	private JComboBox<String> jcomLevel;
	private JButton jbtnTelSearch, jbtnNameSearch, jbtnPoint;
	private JButton jbtnBuy, jbtnLevelOutput, jbtnAllOutput, jbtnInsert, jbtnTelUpdate, jbtnDelete, jbtnExit;
	private JTextArea jtxtPool;
	private JScrollPane scrollPane;
	
	private String 				driver;
	private String 				url;
	private Connection 			conn;
	private PreparedStatement 	pstmt;
	private ResultSet 			rs;

	public CustomerMng(String title) {
		super(title);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		container = getContentPane();
		container.setLayout(new FlowLayout());
		
		jpup = new JPanel(new GridLayout(6, 3));
		jpbtn = new JPanel();
		jtxtId = new JTextField(20);
		jtxtTel = new JTextField(20);
		jtxtName = new JTextField(20);
		jtxtPoint = new JTextField(20);
		jtxtAmount = new JTextField(20);
		
		levels = new Vector<String>();
		levels.add("");
		jcomLevel = new JComboBox<String>(levels);
		
		driver = "oracle.jdbc.driver.OracleDriver";
		url = "jdbc:oracle:thin:@localhost:1521:xe";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement("SELECT LEVELNAME FROM CUS_LEVEL");
			rs = pstmt.executeQuery();
			while(rs.next()) {
				levels.add(rs.getString(1));
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
		
		jbtnTelSearch = new JButton("폰4자리(FULL) 검색");
		jbtnNameSearch = new JButton("고객 이름 검색");
		jbtnPoint = new JButton("포인트로만 구매");
		jpup.add(new JLabel(" 아 이 디 ", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtId);
		jpup.add(new JLabel(""));
		jpup.add(new JLabel("고 객 전 화", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtTel);
		jpup.add(jbtnTelSearch);
		jpup.add(new JLabel("고 객 이 름", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtName);
		jpup.add(jbtnNameSearch);
		jpup.add(new JLabel("포  인  트", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtPoint);
		jpup.add(jbtnPoint);
		jpup.add(new JLabel("구 매 금 액", (int) CENTER_ALIGNMENT));
		jpup.add(jtxtAmount);
		jpup.add(new JLabel(""));// 빈 라벨 추가하는 부분
		jpup.add(new JLabel("고 객 등 급", (int) CENTER_ALIGNMENT));
		jpup.add(jcomLevel);
		
		jbtnBuy = new JButton("물품 구매");
		jbtnLevelOutput = new JButton("등급별출력");
		jbtnAllOutput = new JButton("전체출력");
		jbtnInsert = new JButton("회원가입");
		jbtnTelUpdate = new JButton("번호수정");
		jbtnDelete = new JButton("회원탈퇴");
		jbtnExit = new JButton("나가기");
		jpbtn.add(jbtnBuy);
		jpbtn.add(jbtnLevelOutput);
		jpbtn.add(jbtnAllOutput);
		jpbtn.add(jbtnInsert);
		jpbtn.add(jbtnTelUpdate);
		jpbtn.add(jbtnDelete);
		jpbtn.add(jbtnExit);
		
		jtxtPool = new JTextArea(6, 60);
		scrollPane = new JScrollPane(jtxtPool);
		container.add(jpup);
		container.add(jpbtn);
		container.add(scrollPane);
		
		setSize(new Dimension(750, 380));
		setLocation(200, 200);
		setVisible(true);
		setResizable(false);
		jtxtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");
		
		jbtnTelSearch.addActionListener(this);
		jbtnNameSearch.addActionListener(this);
		jbtnPoint.addActionListener(this);
		jbtnBuy.addActionListener(this);
		jbtnLevelOutput.addActionListener(this);
		jbtnAllOutput.addActionListener(this);
		jbtnInsert.addActionListener(this);
		jbtnTelUpdate.addActionListener(this);
		jbtnDelete.addActionListener(this);
		jbtnExit.addActionListener(this);
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		ArrayList<CustomerDTO> customers = new ArrayList<CustomerDTO>();

		String 	ctel = "";
		String 	cname = "";
		int		cid = 0;
		int		point = 0;
		int		amount = 0;
		String 	levelname = "";
		int		levelup = 0;
		String sql = "";
		
		if(e.getSource() == jbtnTelSearch) {
			// 폰 4자리(FULL)검색
			ctel = jtxtTel.getText().trim();
			jtxtPool.setText("");
			
			if(ctel.equals("")) {
				jtxtPool.setText("전화번호를 입력해주세요");
				JOptionPane.showMessageDialog(container, "전화번호를 입력해주세요");
				return;
			} else if (ctel.length() < 4) {
				jtxtPool.setText("4자리이상 입력해주세요");
				JOptionPane.showMessageDialog(container, "4자리이상 입력해주세요");
				return;
			}
			
			sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
					"       (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) LEVELUP" + 
					"  FROM CUSTOMER C, CUS_LEVEL L" + 
					"  WHERE C.LEVELNO = L.LEVELNO AND CTEL LIKE '%'||?";
			
			try {
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ctel);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					ctel = rs.getString("CTEL");
					cname = rs.getString("CNAME");
					point =  rs.getInt("CPOINT");
					amount = rs.getInt("CAMOUNT");
					levelname =  rs.getString("LEVELNAME");
					levelup = rs.getInt("LEVELUP");

					jtxtId.setText(rs.getString("CID"));
					jtxtTel.setText(ctel);
					jtxtName.setText(cname);
					jtxtPoint.setText(String.format("%d", point));
					jtxtAmount.setText(String.format("%d", amount));
					jcomLevel.setSelectedItem(levelname);
					
					customers.add(new CustomerDTO(ctel, cname, point, amount, levelname, levelup));
				} 
				
				if(customers.size() == 0) {
					// 검색된 번호가 없을때
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("해당 번호의 회원을 찿을 수가 없습니다.");
					JOptionPane.showMessageDialog(container, "해당 번호의 회원을 찿을 수가 없습니다.");	
				} else if(customers.size() >= 1) {
					// 검색된 번호가 1개 이상일때 출력
					jtxtPool.setText("전화\t 이름\t 포인트\t 구매누적금액\t 레벨업을위한 앞으로의 금액\n");
					jtxtPool.append("------------------------------------------------------------------------------------------------------------------------------\n");
					
					for(CustomerDTO c : customers) {
						jtxtPool.append(c.toString()+"\n");
					}
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL error");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
		} else if (e.getSource() == jbtnNameSearch) {
			// 고객이름 검색
			
			cname = jtxtName.getText().trim();
			jtxtPool.setText("");
			
			if(cname.equals("")) {
				jtxtPool.setText("이름을 입력해주세요");
				JOptionPane.showMessageDialog(container, "이름을 입력해주세요");
				return;
			}
			
			sql = "SELECT CID, CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
					"       (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) LEVELUP " + 
					"FROM CUSTOMER C, CUS_LEVEL L " + 
					"WHERE C.LEVELNO = L.LEVELNO AND CNAME LIKE ?";
			
			try {
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, cname);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					ctel = rs.getString("CTEL");
					cname = rs.getString("CNAME");
					point =  rs.getInt("CPOINT");
					amount = rs.getInt("CAMOUNT");
					levelname =  rs.getString("LEVELNAME");
					levelup = rs.getInt("LEVELUP");
					
					jtxtId.setText(rs.getString("CID"));
					jtxtTel.setText(ctel);
					jtxtName.setText(cname);
					jtxtPoint.setText(String.format("%d", point));
					jcomLevel.setSelectedItem(levelname);
					
					customers.add(new CustomerDTO(ctel, cname, point, amount, levelname, levelup));
				} 
				
				if(customers.size() == 0) {
					// 검색된 이름이 없을때
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("해당 이름의 회원을 찿을 수가 없습니다.");
					JOptionPane.showMessageDialog(container, "해당 이름의 회원을 찿을 수가 없습니다.");
					
				} else if(customers.size() >= 1) {
					// 검색된 이름이 1개 이상일때 출력
					jtxtPool.setText("전화\t 이름\t 포인트\t 구매누적금액\t 레벨업을위한 앞으로의 금액\n");
					jtxtPool.append("------------------------------------------------------------------------------------------------------------------------------\n");
					
					for(CustomerDTO c : customers) {
						jtxtPool.append(c.toString()+"\n");
					}
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL error");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == jbtnPoint) {
			// 포인트로 구매
			sql = "UPDATE CUSTOMER SET CPOINT = CPOINT-? WHERE CID = ?";
			
			String id = jtxtId.getText().trim();
			point = Integer.parseInt(jtxtPoint.getText());
			amount = Integer.parseInt(jtxtAmount.getText());;
			
			if(point >= amount && id.length() != 0) {
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, amount);
					pstmt.setString(2, id);
					int result = pstmt.executeUpdate();
					if(result > 0) {
						jtxtPool.setText("포인트로 구매성공");
						jtxtPoint.setText(String.valueOf(point-amount));
						jtxtAmount.setText("");
					} else {
						jtxtPool.setText("해당 ID가 없습니다.");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			} else {
				jtxtPool.setText("포인트가 부족하여 구매할수 없거나 ID가 없습니다.");
				jtxtAmount.setText("");
				JOptionPane.showMessageDialog(container, "포인트가 부족하여 구매할수 없거나 ID가 없습니다.");
			}
			
		} else if (e.getSource() == jbtnBuy) {
			// 물품 구매
			sql = "UPDATE CUSTOMER SET CPOINT = (?*0.05) + CPOINT , " + 
					"                    CAMOUNT = CAMOUNT + ?, " + 
					"                    LEVELNO = (SELECT L.LEVELNO " + 
					"                               FROM CUSTOMER C, CUS_LEVEL L " + 
					"                               WHERE CAMOUNT + ? BETWEEN LOW AND HIGH AND CID = ?) " + 
					"WHERE CID = ?";
			
			String id = jtxtId.getText().trim();
			amount = Integer.parseInt(jtxtAmount.getText());
			point = Integer.parseInt(jtxtPoint.getText());
			
			if(amount !=0 && id.length() != 0) {
				try {
					conn = DriverManager.getConnection(url,"scott","tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setInt(1, amount);
					pstmt.setInt(2, amount);
					pstmt.setInt(3, amount);
					pstmt.setString(4, id);
					pstmt.setString(5, id);
					
					int result = pstmt.executeUpdate();
					if(result > 0) {
						jtxtPool.setText("물품구매후 레벨조정성공");
						jtxtPoint.setText(String.valueOf(point+(long)(amount*0.05)));
						
						jtxtAmount.setText("");
					} else {
						jtxtPool.setText("물품구매 실패");
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} finally {
					try {
						if(rs!=null) rs.close();
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
			} else {
				jtxtPool.setText("구매금액이 없거나 ID가 없습니다.");
				JOptionPane.showMessageDialog(container, "구매금액이 없거나 ID가 없습니다.");
			}
			
		} else if (e.getSource() == jbtnLevelOutput) {
			// 등급별 출력
			sql = "SELECT CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, HIGH, " + 
					"       (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) LEVELUP " + 
					"FROM CUSTOMER C, CUS_LEVEL L " + 
					"WHERE C.LEVELNO = L.LEVELNO AND C.LEVELNO = (SELECT LEVELNO FROM CUS_LEVEL WHERE LEVELNAME = ?)" +
					"AND CWITHDRAW = 0";
			
			levelname = jcomLevel.getSelectedItem().toString();
			
			if (levelname.equals("")) {
				jtxtPool.setText("고객등급을 선택해주세요");
				JOptionPane.showMessageDialog(container, "고객등급을 선택해주세요");
				return;
			}
				
			try {
				
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, levelname);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					ctel = rs.getString("CTEL");
					cname = rs.getString("CNAME");
					point =  rs.getInt("CPOINT");
					amount = rs.getInt("CAMOUNT");
					levelname =  rs.getString("LEVELNAME");
					levelup = rs.getInt("LEVELUP");
					
					customers.add(new CustomerDTO(ctel, cname, point, amount, levelname, levelup));
				} 

				if(customers.size() == 0) {
					// 검색된 등급의 회원이 없을때
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("해당등급의 회원이 없습니다.");
					JOptionPane.showMessageDialog(container, "해당등급의 회원이 없습니다.");
					
				} else if(customers.size() >= 1) {
					// 검색된 회원이 1명 이상일때 출력
					jtxtPool.setText("전화\t 이름\t 포인트\t 구매누적금액\t 레벨업을위한 앞으로의 금액\n");
					jtxtPool.append("------------------------------------------------------------------------------------------------------------------------------\n");
					
					for(CustomerDTO c : customers) {
						jtxtPool.append(c.toString()+"\n");
					}
					
					jtxtPool.append("------------------------------------------------------------------------------------------------------------------------------\n");
					jtxtPool.append("총 "+ customers.size() +"명");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL error");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == jbtnAllOutput) {
			// 전체 출력
			sql = "SELECT CTEL, CNAME, CPOINT, CAMOUNT, LEVELNAME, " + 
				  "       (SELECT HIGH-CAMOUNT+1 FROM CUSTOMER WHERE CID=C.CID AND LEVELNO != 5) LEVELUP " + 
				  "FROM CUSTOMER C, CUS_LEVEL L " + 
				  "WHERE C.LEVELNO = L.LEVELNO AND CWITHDRAW = 0";
			
			try {
				
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				rs = pstmt.executeQuery();
				
				while(rs.next()) {
					
					ctel = rs.getString("CTEL");
					cname = rs.getString("CNAME");
					point =  rs.getInt("CPOINT");
					amount = rs.getInt("CAMOUNT");
					levelname =  rs.getString("LEVELNAME");
					levelup = rs.getInt("LEVELUP");
					
					customers.add(new CustomerDTO(ctel, cname, point, amount, levelname, levelup));
				} 
				
				if(customers.size() == 0) {
					// 검색된 회원이 없을때
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("검색된 회원이 없습니다.");
					JOptionPane.showMessageDialog(container, "검색된 회원이 없습니다.");
					
				} else if(customers.size() >= 1) {
					// 검색된 회원이 1명이상일때 출력
					jtxtPool.setText("전화\t 이름\t 포인트\t 구매누적금액\t 레벨업을위한 앞으로의 금액\n");
					jtxtPool.append("------------------------------------------------------------------------------------------------------------------------------\n");
					
					for(CustomerDTO c : customers) {
						jtxtPool.append(c.toString()+"\n");
					}
					
					jtxtPool.append("------------------------------------------------------------------------------------------------------------------------------\n");
					jtxtPool.append("총 "+ customers.size() +"명");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL error");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == jbtnInsert) {
			// 회원가입
			sql = "INSERT INTO CUSTOMER(CID, CTEL, CNAME) VALUES (CUS_SEQ.nextval, ?, ?)";
			ctel = jtxtTel.getText().trim();
			cname = jtxtName.getText().trim();
			
			if (ctel.equals("")) {
				jtxtPool.setText("전화번호를 입력해주세요");
				JOptionPane.showMessageDialog(container, "전화번호를 입력해주세요");
				return;
			}
			
			if (cname.equals("")) {
				jtxtPool.setText("이름을 입력해 주세요.");
				JOptionPane.showMessageDialog(container, "이름을 입력해 주세요.");
				return;
			}
			
			try {
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ctel);
				pstmt.setString(2, cname);
				
				int result = pstmt.executeUpdate();
				
				if (result !=0) {
					// 회원가입 성공
					jtxtPool.setText(cname + "님 회원가입 되었습니다. 기본 포인트 1000점 적립");
					JOptionPane.showMessageDialog(container, cname + "님 회원가입 되었습니다. 기본 포인트 1000점 적립");
				} else {
					// 회원가입 실패
					jtxtPool.setText(cname + "님 회원가입 실패");
					JOptionPane.showMessageDialog(container, cname + "님 회원가입 실패");
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
			
		} else if (e.getSource() == jbtnTelUpdate) {
			// 번호수정
			sql = "UPDATE CUSTOMER SET CTEL = ? WHERE CID = ?";
			
			ctel = jtxtTel.getText().trim();
			
			if (ctel.equals("")) {
				jtxtPool.setText("전화번호를 입력해주세요");
				JOptionPane.showMessageDialog(container, "전화번호를 입력해주세요");
				return;
			}
			
			if (jtxtId.getText().trim().equals("")) {
				jtxtPool.setText("회원번호가 없습니다. 회원을 검색해주세요.");
				JOptionPane.showMessageDialog(container, "회원번호가 없습니다. 회원을 검색해주세요.");
				return;
			}
			
			try {
				cid = Integer.parseInt(jtxtId.getText().trim());
			} catch (Exception e2) {
				jtxtPool.setText("해당회원번호가 없습니다. 회원을 검색해주세요.");
				JOptionPane.showMessageDialog(container, "해당회원번호가 없습니다. 회원을 검색해주세요");
				return;
			}
			
				
			try {
				
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1, ctel);
				pstmt.setInt(2, cid);
				int result = pstmt.executeUpdate();
				
				if(result != 0) {
					
					jtxtPool.setText("번호가 수정되었습니다.");
					JOptionPane.showMessageDialog(container, "번호가 수정되었습니다.");
					
				} else {
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("번호수정 실패.");
					JOptionPane.showMessageDialog(container, "번호수정 실패.");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL error");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == jbtnDelete) {
			// 회원탈퇴
			sql = "UPDATE CUSTOMER SET CWITHDRAW = 1 WHERE CID = ?";
			
			if (jtxtId.getText().trim().equals("")) {
				jtxtPool.setText("회원번호가 없습니다. 회원을 검색해주세요.");
				JOptionPane.showMessageDialog(container, "회원번호가 없습니다. 회원을 검색해주세요.");
				return;
			}
			
			try {
				cid = Integer.parseInt(jtxtId.getText().trim());
			} catch (Exception e2) {
				jtxtPool.setText("해당회원번호가 없습니다. 회원을 검색해주세요.");
				JOptionPane.showMessageDialog(container, "해당회원번호가 없습니다. 회원을 검색해주세요");
				return;
			}
				
			try {
				
				conn = DriverManager.getConnection(url,"scott","tiger");
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, cid);
				int result = pstmt.executeUpdate();
				
				if(result != 0) {
					
					jtxtPool.setText("회원탈퇴 처리되었습니다.");
					JOptionPane.showMessageDialog(container, "회원탈퇴 처리되었습니다.");
					
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("\t★ ★ ★ 고객검색 후 구매하세요 ★ ★ ★");
					
				} else {
					jtxtId.setText("");
					jtxtTel.setText("");
					jtxtName.setText("");
					jtxtPoint.setText("");
					jtxtAmount.setText("");
					jcomLevel.setSelectedIndex(0);
					jtxtPool.setText("회원탈퇴 실패.");
					JOptionPane.showMessageDialog(container, "회원탈퇴 실패.");
				}
				
			} catch (SQLException e1) {
				System.out.println(e1.getMessage() + "SQL error");
			} finally {
				try {
					if(rs!=null) rs.close();
					if(pstmt != null) pstmt.close();
					if(conn != null) conn.close();
				} catch (Exception e2) {
					// TODO: handle exception
				}
			}
			
		} else if (e.getSource() == jbtnExit) {
			// 나가기
			int answer = JOptionPane.showConfirmDialog(null, "종료하시겠습니까?");
			if(answer == 0) {
				setVisible(false);
				dispose();
				System.exit(0);
			}
		}
		
	}
	
	public static void main(String[] args) {
		new CustomerMng("고객관리");
	}
}
