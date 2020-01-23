package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementUpdateSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		
		// 부서번호를 입력받아 있는 부서번호이면 수정작업(부서이름, 부서위치를 받아 수정)
		// 없는 부서번호이면 없다고 출력
		String selectSQL = "SELECT COUNT(*) CNT FROM DEPT WHERE DEPTNO = ?";
		String updateSQL = "UPDATE DEPT SET DNAME = ?, LOC = ? WHERE DEPTNO = ?";
		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서번호는? : ");
		int deptno = sc.nextInt();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(selectSQL);
			pstmt.setInt(1, deptno);
			rs = pstmt.executeQuery();
			rs.next();
			int cnt = rs.getInt("cnt");
			if(cnt > 0) {
				System.out.print("수정할 부서이름은? : ");
				String dname = sc.next();
				System.out.print("수정할 부서위치는? : ");
				String loc = sc.next();
				
				rs.close();		// RESULT SET 닫아주기
				pstmt.close();	// 기존의 PSTMT 닫아주고 밑에서 다시열기
				
				pstmt = conn.prepareStatement(updateSQL);
				// ? 순서대로 값 채워주기
				pstmt.setString(1, dname);
				pstmt.setString(2, loc);
				pstmt.setInt(3, deptno);
				
				int result = pstmt.executeUpdate();
				
				System.out.println(result > 0 ? "수정성공":"수정실패");
				
			} else {
				System.out.println("해당 부서를 찿을수없습니다.");
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
				if(sc != null) sc.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
		
	}
}
