package com.tj.ex5delete;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteOracle {
	public static void main(String[] args) {
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
//			rs = stmt.executeQuery(selectSQL);
//			if(rs.next()) {
				String deleteSQL = String.format("DELETE FROM DEPT WHERE DEPTNO = %d", deptno);
				int result = stmt.executeUpdate(deleteSQL);
				System.out.println(result > 0 ? "삭제성공":"삭제실패");
//			} else {
//				System.out.println("해당하는 부서를 찿을수 없습니다.");
//			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB접속 에러");
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL 에러");
		} finally {
			try {
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
