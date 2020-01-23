package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서이름은? : ");
		String dname = sc.nextLine();
		String sql = String.format("SELECT * FROM DEPT WHERE DNAME ='%s'", dname.toUpperCase());
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2단계 DB연결
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			
			if(rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("입력한 부서 번호 : " + deptno);
				System.out.println("입력한 부서 이름 : " + dname);
				System.out.println("입력한 부서 위치 : " + loc);
			} else {
				System.out.println("해당하는 부서이름이 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"DB접속 에러");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage()+"SQL 에러");
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
