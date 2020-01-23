package com.tj.student;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Scanner;

public class ConsoleStudentMng {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		Scanner sc = new Scanner(System.in);
		String fn = "";
		ArrayList<StudentDTO> students = new ArrayList<StudentDTO>();
		
		Connection 			conn = null;
		PreparedStatement 	pstmt = null;
		Statement 			stmt = null;
		ResultSet 			rs = null;
		
		String sName, mName, nameNo;
		int score;
		int rank;
		
		
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB error");
		}
		
		do {
			System.out.print("1:입력(이름,학과명,점수), 2:학과별출력(학과명), 3: 전체출력(제적생제외), 그외:(종료) : ");
			fn = sc.next();
			switch (fn) {
			case "1":	// 입력작업(이름, 학과명, 점수를 받아 insert)
				String sql = "INSERT INTO STUDENT (sNO, sNAME, mNO, SCORE) VALUES (" + 
						"    TO_CHAR(SYSDATE,'YYYY') || (SELECT mNO FROM MAJOR WHERE mNAME = ?) || TRIM(TO_CHAR(STD_SEQ.nextval,'000'))," + 
						"    ?," + 
						"    (SELECT mNO FROM MAJOR WHERE mNAME = ?)," + 
						"    ?)";
				
				System.out.print("이름 : ");
				sName = sc.next();
				System.out.print("학과명 : ");
				mName = sc.next();
				System.out.print("점수 : ");
				score = sc.nextInt();
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					pstmt.setString(2, sName);
					pstmt.setString(3, mName);
					pstmt.setInt(4, score);
					
					int result = pstmt.executeUpdate();
					
					System.out.println(result>0 ? sName+"입력성공" : sName+"입력실패");
					
				} catch (SQLException e) {
					System.out.println(e.getMessage() + "SQL error");
				} finally {
					try {
						if(pstmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				break;

			case "2":	// 학과별출력(학과이름입력받아 해당학생출력)
				sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE " + 
						"FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND mNAME = ? ORDER BY SCORE DESC)";
				System.out.print("학과명을 입력하세요 : ");
				mName = sc.next();
				
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, mName);
					rs = pstmt.executeQuery();
					students.clear();
					
					if(rs.next()) {
						do {
							rank 	= rs.getInt(1);
							nameNo 	= rs.getString(2);
							mName 	= rs.getString(3);
							score 	= rs.getInt(4);
							students.add(new StudentDTO(rank, nameNo, mName, score));
						} while (rs.next());
						
						if(!students.isEmpty()) {
							// 출력하기
							System.out.println("등수\t 이름(sNO)\t\t 학과\t\t 점수");
							System.out.println("---------------------------------------------------------");
							
							for(StudentDTO s : students) {
								System.out.println(s);
							}
							
						} else {
							System.out.println("해당학과명을 검색할수없습니다. 바르게 입력해보세요.");
						}
						
					} else {
						System.out.println("해당학과명을 검색할수없습니다. 바르게 입력해보세요.");
					}
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
				break;
				
			case "3":	// 전체출력(studens이용)
				
				sql = "SELECT ROWNUM RANK, sNAME||'('||sNO||')' NAME_NO, mNAME, SCORE " + 
						"FROM (SELECT * FROM STUDENT S, MAJOR M WHERE S.mNO = M.mNO AND sEXPEL = 0 ORDER BY SCORE DESC)";
				try {
					conn = DriverManager.getConnection(url, "scott", "tiger");
					stmt = conn.createStatement();
					rs = stmt.executeQuery(sql);
					students.clear();
					while (rs.next()) {
						rank 	= rs.getInt(1);
						nameNo 	= rs.getString(2);
						mName 	= rs.getString(3);
						score 	= rs.getInt(4);
						students.add(new StudentDTO(rank, nameNo, mName, score));
					}
					if (!students.isEmpty()) {
						// 출력하기
						System.out.println("등수\t 이름(sNO)\t\t 학과\t\t 점수");
						System.out.println("---------------------------------------------------------");
						
						for(StudentDTO s : students) {
							System.out.println(s);
						}
					} else {
						System.out.println("조회한 데이터가 없습니다.");
					}
				} catch (SQLException e) {
					System.out.println(e.getMessage() + "SQL error");
				} finally {
					try {
						if(rs != null) rs.close();
						if(stmt != null) pstmt.close();
						if(conn != null) conn.close();
					} catch (Exception e2) {
						// TODO: handle exception
					}
				}
				
				break;
				
			default:
				break;
			}
		} while (fn.equals("1")||fn.equals("2")||fn.equals("3"));
		
		System.out.println("프로그램을 종료합니다.");
		sc.close();
	}
}
