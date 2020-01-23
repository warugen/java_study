package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PreparedStatementDelete {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		// 부서번호를 입력받아 있는 부서번호이면 수정작업(부서이름, 부서위치를 받아 수정)
		// 없는 부서번호라면 없다고 출력
		// select(stmt객체이용), update(pstmt객체이용)
		Scanner sc = new Scanner(System.in);
		System.out.print("부서번호를 입력하세요 : ");
		int deptno = sc.nextInt();
		
		String selectSQL = String.format("SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = %d", deptno);
		
		String updateSQL = "UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO = ?";
		
		Connection conn = null;
		Statement stmt = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt(1);
			if (cnt == 1) {
				System.out.print("수정할 부서이름을 입력하세요 : ");
				String dname = sc.next();
				System.out.print("수정할 부서위치를 입력하세요 : ");
				String loc = sc.next();
				
				pstmt = conn.prepareStatement(updateSQL);
				pstmt.setString(1, dname.toUpperCase());
				pstmt.setString(2, loc.toUpperCase());
				pstmt.setInt(3, deptno);
				
				int result = pstmt.executeUpdate();
				System.out.println(result > 0 ? "수정성공":"수정실패");
				
			} else {
				System.out.println("해당 부서번호가 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB error");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL error");
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(pstmt != null) pstmt.close();
				if(conn != null) conn.close();
				if(sc != null) sc.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
