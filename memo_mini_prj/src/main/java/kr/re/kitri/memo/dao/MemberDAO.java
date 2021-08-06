package kr.re.kitri.memo.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import kr.re.kitri.memo.dbconn.DBConnect;

public class MemberDAO {
	public void closeAll(Connection conn, PreparedStatement pstmt, Statement stmt, ResultSet rs) {
		try {
			if(conn!=null && !conn.isClosed()) {
				conn.close();
			}
			if(pstmt!=null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if(stmt!=null && !stmt.isClosed()) {
				stmt.close();
			}
			if(rs!=null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}
	public String login(String id, String pw) {
	      //conn
	      Connection conn = DBConnect.getInstance();
	      
	      //sql
	      String sql = "SELECT ID FROM MMEMBER WHERE ID = ? AND PW = ?";
	      
	      //pstmt
	      PreparedStatement pstmt = null;
	      ResultSet rs = null;
	      String result = null;
	      
	      try {
	         pstmt = conn.prepareStatement(sql);
	         pstmt.setString(1, id);
	         pstmt.setString(2, pw);
	         
	         //resultset
	         rs = pstmt.executeQuery();
	         
	         while(rs.next()) {
	            
	            //result
	            result = rs.getString("ID");
	         }
	         
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } finally {
	         closeAll(conn, pstmt, null, rs);
	      }
	      
	      return result;
	      
	   }
}
