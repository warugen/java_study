package com.tj.ex3insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("입력하고자 하는 부서번호는? :");
		int deptno = sc.nextInt();
		System.out.print("입력하고자 하는 부서이름는? :");
		String dname = sc.next();
		System.out.print("입력하고자 하는 부서위치는? :");
		sc.nextLine(); // 버퍼 지우기
		String loc = sc.nextLine();
		
//		String sql = "INSERT INTO DEPT VALUES("+deptno+",'"+dname+"','"+loc+"')";
		String sql = String.format("INSERT INTO DEPT VALUES(%d,'%s','%s')", deptno, dname, loc);
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);	// 1단계 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2단계 DB연결
			stmt = conn.createStatement();	// 3단계 SQL전송할 객체 생성
			int result = stmt.executeUpdate(sql);
			System.out.println(result > 0 ? "입력성공":"입력실패");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				// 7단계 연결해제
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
				if(sc != null) sc.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
