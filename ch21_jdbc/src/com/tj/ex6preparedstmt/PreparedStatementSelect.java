package com.tj.ex6preparedstmt;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class PreparedStatementSelect {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@localhost:1521:xe";
		
		String sql = "SELECT * FROM EMP WHERE DEPTNO = (SELECT DEPTNO FROM DEPT WHERE DNAME = ?)";
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Scanner sc = new Scanner(System.in);
		System.out.print("검색할 부서이름을 입력하세요 : ");
		String dname = sc.next();
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dname.toUpperCase());
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				do {
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					Date hiredate = rs.getDate("hiredate");
//					if((job.length()<6) || (hiredate == null)) {
//						System.out.printf("%d\t %s\t %s\t\t %TF\n", empno, ename, job, hiredate);
//					} else {
						System.out.printf("%d\t %s\t %s\t %TF\n", empno, ename, job, hiredate);
//					}
				} while (rs.next());
			} else {
				System.out.println("해당하는 부서이름이 없습니다.");
			}
			
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "DB error");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println(e.getMessage() + "SQL error");
		} finally {
			try {
				if(rs!=null) rs.close();
				if(pstmt!=null) pstmt.close();
				if(conn !=null) conn.close();
				if(sc != null) sc.close();
			} catch (Exception e2) {
				// TODO: handle exception
			}
		}
	}
}
