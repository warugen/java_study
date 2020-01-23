package com.tj.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllMySQL {
	public static void main(String[] args) {
		String driver = "com.mysql.cj.jdbc.Driver"; // 8.0버전
		String url = "jdbc:mysql://127.0.0.1:3306/kimdb?serverTimezone=UTC";
		String query = "SELECT * FROM PERSONAL";
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "root", "mysql");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(query);
			System.out.println("사번\t 이름\t 직책\t\t상사사번\t 입사일\t 급여\t 상여\t 부서번호");
			while (rs.next()) {
				int pno = rs.getInt(1); 
				String pname = rs.getString("pname");
				String job = rs.getString("job");
				int manager = rs.getInt("manager");
				Date startdate = rs.getDate("startdate");
				int pay = rs.getInt("pay");
				int bonus = rs.getInt("bonus");
				int dno = rs.getInt("dno");
				
				if(job.length()>=4) {
					System.out.println(pno+"\t"+pname+"\t"+job+"\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
				} else {
					System.out.println(pno+"\t"+pname+"\t"+job+"\t\t"+manager+"\t"+startdate+"\t"+pay+"\t"+bonus+"\t"+dno);
				}
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null) rs.close();
				if (stmt != null) stmt.close();
				if (conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
		
	}
}
