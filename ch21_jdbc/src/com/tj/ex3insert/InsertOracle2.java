package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
//		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하고자하는 부서 번호는? : ");
		int deptno = sc.nextInt();
		
		String selectSQL = String.format("SELECT * FROM DEPT WHERE DEPTNO = %d", deptno);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url,"scott","tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			if (!rs.next()) {
				// 중복된 부서번호가 아니면 추가 작업
				System.out.print("입력할 부서이름은? : ");
				String dname = sc.next();
				System.out.print("입력할 부서위치는? : ");
				String loc = sc.next();
				String insertSQL = String.format("INSERT INTO DEPT VALUES (%d, '%s', '%s')", deptno, dname, loc);
				int result = stmt.executeUpdate(insertSQL);
				System.out.println(result > 0 ? "입력성공":"입력실패");
			} else {
				System.out.println("중복된 부서번호가 있습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB연결 에러");
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
