package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDeptno {
	// 1.사용자에게 부서번호 물어보기
	// 2-1. 해당부서번호가 있으면 해당부서이름, 해당부서 위치 출력후 해당부서 사원을 출력
	// 2-2. 해당부서번호가 없으면 해당부서번호가 없다고 출력
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("출력을 원하는 부서번호는? : ");
		int deptno = sc.nextInt();
		String query1 = "SELECT * FROM DEPT WHERE DEPTNO =" + deptno;
		String query2 = "SELECT * FROM EMP WHERE DEPTNO =" + deptno;
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);	// 1단계 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2단계 DB연결
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query1);
			if(rs.next()) {
				do {
					String dname = rs.getString("dname");
					String loc = rs.getString("loc");
					System.out.printf("%s\t %s\n", dname, loc);
				} while (rs.next());
				rs.close();	// 기존의 rs를 닫고 다시 열어준다.
				rs = stmt.executeQuery(query2);
				
				if(rs.next()) {
					do {
						int empno = rs.getInt("empno");
						String ename = rs.getString("ename");
						int deptnum = rs.getInt("deptno");
						System.out.printf("%d\t %s\t %d\n",
				           		empno, ename, deptnum);
					} while (rs.next());
				} else {
					System.out.println(deptno +"번 부서 사원이 없습니다.");
				}
			} else {
				System.out.println("유효하지 않는 부서번호 입니다.");
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
