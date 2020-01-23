package com.tj.ex0conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnOracle {
	public static void main(String[] args) {
		String driver = "oracle.jdbc.driver.OracleDriver";
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
		Connection conn = null;
		
		try {
			Class.forName(driver); // 1단계 드라이버 로드하기
			conn = DriverManager.getConnection(url,"scott","tiger");
			System.out.println("데이터 베이스 연결 성공");
		} catch (ClassNotFoundException e) {
			System.out.println(e.getMessage() + "드라이버 못 찿음");
		} catch (SQLException e) {
			System.out.println(e.getMessage() +"DB연결 오류");
		} finally {
			try {
				if(conn != null) conn.close();
			} catch (Exception e2) {
				System.out.println(e2.getMessage() +"닫기 오류");
			}
		}
	}
}
