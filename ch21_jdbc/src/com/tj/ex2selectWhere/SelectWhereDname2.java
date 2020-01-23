package com.tj.ex2selectWhere;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class SelectWhereDname2 {
	public static void main(String[] args) {
		// 사용자로부터 부서이름을 받아
		// 해당부서이름이 있을경우, 부서정보출력, 해당부서 사원(사번, 이름, 부서위치, 입사일) 
		// 해당부서이름이 없을경우 없다고 출력
		
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Scanner sc = new Scanner(System.in);
		System.out.print("원하는 부서이름은? : ");
		String dname = sc.nextLine();
		String sql1 = String.format("SELECT * FROM DEPT WHERE DNAME ='%s'", dname.toUpperCase());
		String sql2 = String.format("SELECT ENAME, HIREDATE, LOC " + 
				"FROM EMP E, DEPT D " + 
				"WHERE E.DEPTNO=D.DEPTNO " + 
				"AND DNAME ='%s'", dname.toUpperCase());
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2단계 DB연결
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql1);
			if (rs.next()) {
				int deptno = rs.getInt("deptno");
				String loc = rs.getString("loc");
				System.out.println("입력한 부서 번호 : " + deptno);
				System.out.println("입력한 부서 이름 : " + dname.toUpperCase());
				System.out.println("입력한 부서 위치 : " + loc);
				rs.close();
				rs = stmt.executeQuery(sql2);
				if(rs.next()) {
					System.out.println("이름\t 입사일\t\t 부서위치");
					do {
						String ename = rs.getString("ename");
						Date hiredate = rs.getDate("hiredate");
						if(hiredate == null) {
							System.out.printf("%s\t %TF\t\t %s\n", ename, hiredate, loc);
						} else {
							System.out.printf("%s\t %TF\t %s\n", ename, hiredate, loc);
						}
					} while (rs.next());
					
				} else {
					System.out.println("해당부서의 사원이 없습니다.");
				}
			} else {
				System.out.println("해당 부서가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage()+"DB접속 에러");
		} catch (SQLException e) {
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
