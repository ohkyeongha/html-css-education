package com.kitri.visitor.dao;

//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpSession;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

//import com.kitri.visitor.db.DBConnection;
import com.kitri.visitor.vo.VisitorVO;

//인터페이스 정의 후 DAO 작성 ,interface를 받았다고 하여 class명에 impl을 붙인다.
@Repository  //component와 동일한 작용을 하지만 에러가 나는 것을 잡아주는 역할
public class VisitorDAOimpl implements VisitorDAO{
	//VisitorServiceImpl 생성후 > jdbc 내용이 들어가야함.
	@Autowired
	private SqlSession sqlSession;
	
	@Override
	public List<VisitorVO> selectVisitors() {
		return sqlSession.selectList("visitor.selectVisitors");
	}

	@Override
	public int insertVisitor(VisitorVO vo) {
		return sqlSession.insert("visitor.insertVisitor",vo);
	}

	@Override
	public int updateVisitor(VisitorVO vo) {
		return sqlSession.update("visitor.updateVisitor",vo);
	}

	@Override
	public int deleteVisitor(int vno) {
		return sqlSession.delete("visitor.deleteVisitor",vno);
	}
}
