package com.kitri.mini.board.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.kitri.mini.board.vo.ImgBoardVO;

@Repository
public class ImgBoardDAOImpl implements ImgBoardDAO{
	
	@Autowired
	private SqlSession sqlSession;

	@Override
	public List<ImgBoardVO> selectImgBoards(Map<String, String> map) {
		return sqlSession.selectList("imgboard.selectImgBoards", map) ;
	}

	@Override
	public int insertImgBoard(ImgBoardVO ibvo) {
		return sqlSession.insert("imgboard.insertImgBoards", ibvo);
	}

}
