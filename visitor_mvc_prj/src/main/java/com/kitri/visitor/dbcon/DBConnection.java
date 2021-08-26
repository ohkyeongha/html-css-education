package com.kitri.visitor.dbcon;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
	private static Connection conn;

	private DBConnection() {}

	public static Connection getConnection() {
		String user = "web"; // 계정
		String password = "web";// 비밀번호
		String url = "jdbc:oracle:thin:@localhost:1521:xe";// 접속 url
		String dirver = "oracle.jdbc.driver.OracleDriver";
		
		Connection conn = null;
		
		try {
			Class.forName(dirver);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc lib 오류");
			e.printStackTrace();
		} catch (SQLException e) {
			System.out.println("url, user, password 오류");
			e.printStackTrace();
		}
		System.out.println("DB 연결 완료");
		return conn;
	}
}
