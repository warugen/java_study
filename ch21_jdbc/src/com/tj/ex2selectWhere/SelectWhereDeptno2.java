package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno2 {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("출력을 원하는 부서번호는? : ");
		int deptno = sc.nextInt();
		String query = "SELECT * FROM EMP WHERE DEPTNO =" + deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);	// 1단계 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2단계 DB연결
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int deptnum = rs.getInt("deptno");
					System.out.printf("%d\t %s\t %d\n",
			           		empno, ename, deptnum);
				} while (rs.next());
			} else {
				System.out.println("해당 부서번호 사원이 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				// 7단계 연결해제
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				if(sc != null) sc.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
}
