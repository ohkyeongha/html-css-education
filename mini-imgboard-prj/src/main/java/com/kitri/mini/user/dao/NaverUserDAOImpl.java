package com.kitri.mini.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitri.mini.user.vo.NaverUserVO;

@Repository
public class NaverUserDAOImpl implements NaverUserDAO{

	@Autowired
	private SqlSession sqlSession;
	@Override
	public NaverUserVO selectNaverUser(String email) {
		return sqlSession.selectOne("naveruser.selectNaverUser", email);
	}

	@Override
	public int insertNaverUser(NaverUserVO nuvo) {
		int result = sqlSession.insert("naveruser.insertNaverUser",nuvo);
		return result;
	}
	
}
