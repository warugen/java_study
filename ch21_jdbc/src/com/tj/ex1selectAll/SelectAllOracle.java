package com.tj.ex1selectAll;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class SelectAllOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		String query = "SELECT * FROM EMP";
		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			Class.forName(driver);	// 1단계 드라이버 로드
			conn = DriverManager.getConnection(url, "scott", "tiger");	// 2단계 DB연결
			stmt = conn.createStatement();	// 3단계 SQL전송할 객체 생성
			rs = stmt.executeQuery(query);	// 4단계 SQL전송 5단계 SQL문 결과 rs에 받기
			
			if(rs.next()) {					// 6단계 결과를 받아 원하는 로직 수행
				do {
					// rs값 출력
					int empno = rs.getInt("empno");
					String ename = rs.getString("ename");
					String job = rs.getString("job");
					int mgr = rs.getInt("mgr");
					Date hiredate = rs.getDate("hiredate");
					int sal = rs.getInt("sal");
					int comm = rs.getInt("comm");
					int deptno = rs.getInt("deptno");
					if(job != null && job.length()>=7) {
						System.out.printf("%d\t %s\t %s\t %d\t %TF\t %d\t %d\t %d\n",
						           		empno, ename, job, mgr, hiredate, sal, comm, deptno);
					} else {
						System.out.printf("%d\t %s\t %s\t\t %d\t %TF\t %d\t %d\t %d\n",
						           		empno, ename, job, mgr, hiredate, sal, comm, deptno);
					}
					
					
				} while (rs.next());
			} else {
				System.out.println("데이터가 없습니다.");
			}
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		} finally {
			try {
				// 7단계 연결해제
				if(rs != null) rs.close();
				if(stmt != null) stmt.close();
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage());
			}
		}
	}
}
