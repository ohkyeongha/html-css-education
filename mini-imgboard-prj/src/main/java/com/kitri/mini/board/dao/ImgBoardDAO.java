package com.kitri.mini.board.dao;

import java.util.List;
import java.util.Map;

import com.kitri.mini.board.vo.ImgBoardVO;

public interface ImgBoardDAO {
	public List<ImgBoardVO> selectImgBoards(Map<String, String> map);
	public int insertImgBoard(ImgBoardVO ibvo);
}
