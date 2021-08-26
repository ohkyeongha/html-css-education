package com.kitri.visitor.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.kitri.visitor.dbcon.DBConnection;
import com.kitri.visitor.vo.VisitorVO;

@Repository
public class VisitorDAOImpl implements VisitorDAO {

	public void closeAll(Connection conn, PreparedStatement pstmt, ResultSet rs) {
		try {
			if (conn != null && !conn.isClosed()) {
				conn.close();
			}
			if (pstmt != null && !pstmt.isClosed()) {
				pstmt.close();
			}
			if (rs != null && !rs.isClosed()) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	// jdbc
	@Override
	public List<VisitorVO> selectVisitors() {
		// conn
		Connection conn = DBConnection.getConnection();
		// sql
		String sql = "SELECT * FROM VISITOR";
		// pstmt
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<VisitorVO> vlist = new ArrayList<VisitorVO>();

		try {
			pstmt = conn.prepareStatement(sql);

			// result
			rs = pstmt.executeQuery();
			while (rs.next()) {
				VisitorVO vvo = new VisitorVO();
				vvo.setVno(rs.getInt(1));
				vvo.setNickname(rs.getString(2));
				vvo.setContent(rs.getString(3));
				vvo.setRegdate(rs.getDate(4));

				vlist.add(vvo);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, rs);
		}

		return vlist;
	}

	@Override
	public int insertVisitor(VisitorVO vvo) {

		// conn
		Connection conn = DBConnection.getConnection();
		// sql
		String sql = "INSERT INTO VISITOR(VNO, NICKNAME, CONTENT, REGDATE)"
				+ " VALUES (VISITOR_VNO_SEQ.NEXTVAL,?,?,SYSDATE";
		// pstmt
		PreparedStatement pstmt = null;
		int result = 0;
		
		try {
			
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1, vvo.getNickname());
			pstmt.setString(2, vvo.getContent());
			
			result = pstmt.executeUpdate();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {

		Connection conn = DBConnection.getConnection();
		
		String sql = "UPDATE VISITOR"
				+ " SET CONTENT = ?"
				+ " WHERE VNO = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vvo.getContent());
			pstmt.setInt(2, vvo.getVno());
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}

	@Override
	public int deleteVisitor(int vno) {
Connection conn = DBConnection.getConnection();
		
		String sql = "DELETE FROM VISITOR"
				+ " WHERE VNO = ?";
		int result = 0;
		PreparedStatement pstmt = null;
		
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vno);
			
			result = pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			closeAll(conn, pstmt, null);
		}
		return result;
	}

}
