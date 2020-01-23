package com.tj.ex4update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class UpdateOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";		
		Scanner sc = new Scanner(System.in);
		System.out.print("수정할 부서번호는? :");
		int deptno = sc.nextInt();
		String selectSQL = String.format("SELECT COUNT(*) FROM DEPT WHERE DEPTNO = %d", deptno);
		
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs =null;
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "scott", "tiger");
			stmt = conn.createStatement();
			rs = stmt.executeQuery(selectSQL);
			rs.next();
			int cnt = rs.getInt(1);
			if ( cnt == 1) {
				// 해당 부서번호가 있는경우
				System.out.print("수정하고자하는 부서이름은? : ");
				String dname = sc.next();
				System.out.print("수정하고자하는 부서위치는? : ");
				String loc = sc.next();
				
				String updateSQL = String.format(
						"UPDATE DEPT SET DNAME = '%s', LOC='%s' WHERE DEPTNO = %d", 
						dname, loc, deptno);
				int result = stmt.executeUpdate(updateSQL);
				System.out.println(result > 0 ? "수정성공":"수정실패");
			} else {
				// 해당 부서번호가 존재하지 않는경우
				System.out.println("존재하지 않는 부서번호입니다.");
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
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
