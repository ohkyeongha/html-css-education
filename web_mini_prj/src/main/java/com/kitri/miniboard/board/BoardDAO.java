package com.kitri.miniboard.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.kitri.miniboard.db.DBConnect;

public class BoardDAO {
	
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
	//게시판 전체 글 조회
	public List<BoardVO> selectBoardList(){
		//conn
		Connection conn = DBConnect.getInstance();
		//sql
		String sql = "SELECT * FROM BOARD";
		Statement stmt = null;
		ResultSet rs = null;
		List<BoardVO> blist = new ArrayList<BoardVO>();
		//statement
		try {
			stmt = conn.createStatement();
			//resultset
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				BoardVO bvo = new BoardVO();
				bvo.setBno(rs.getInt("bno"));
				bvo.setbTitle(rs.getString(2));
				bvo.setbContent(rs.getString(3));
				bvo.setbWriter(rs.getString(4));
				bvo.setbRegDate(rs.getDate(5));
				
				//list<boardDAO>
				blist.add(bvo);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, null, stmt, rs);
		}
		
		return blist;
	}
}
