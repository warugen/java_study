package com.tj.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle2 {
	public static void main(String[] args) {
		// 1. 삭제할 부서번호를 입력
		// 2-1. 존재하는 부서번호일경우 : 진짜 삭제할지 물어보고(Y/N) 진행
		//		Y입력시 해당부서번호 삭제
		//		N입력시 프로그램 끝
		
		// 2-2 존재하지않는 부서번호일 경우 : 존재하지않는 부서번호입니다 출력
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("삭제하고자 하는 부서 번호는? :");
		int deptno = sc.nextInt();
		String selectSQL = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", deptno);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if(rs.next()) {
				System.out.print("정말 삭제 할까요? (Y / N) : ");
				String answer = sc.next();
				if(answer.equalsIgnoreCase("y")) {
					String deleteSQL = String.format("DELETE FROM DEPT WHERE DEPTNO = %d", deptno);
					int result = stmt.executeUpdate(deleteSQL);
					System.out.println(result > 0 ? "삭제성공":"삭제실패");
				} else if (answer.equalsIgnoreCase("n")) {
					System.out.println("삭제 취소하였습니다.");
				}
				
			} else {
				System.out.println("해당하는 부서를 찿을수 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB접속 에러");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL 에러");
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				if(sc != null) sc.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
