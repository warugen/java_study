package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementInsert {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		String sql = "INSERT INTO DEPT VALUES (?, ?, ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		System.out.print("부서이름를 입력하세요 : ");
		String dname = sc.next();
		System.out.print("부서위치를 입력하세요 : ");
		String loc = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			pstmt = conn.prepareStatement(sql);
			// SQL문 ?에 해당하는 값 채우기
			pstmt.setInt(1, deptno);
			pstmt.setString(2, dname);
			pstmt.setString(3, loc);
			
			int rs = pstmt.executeUpdate();
			System.out.println(rs > 0 ? "입력성공":"입력실패");
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB접속에러");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL 에러");
		} finally {
			try {
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(sc != null) sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
