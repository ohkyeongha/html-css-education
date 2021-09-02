package com.kitri.mini.board.service;

import java.util.List;
import java.util.Map;

import com.kitri.mini.board.vo.ImgBoardVO;

public interface ImgBoardService {
	public List<ImgBoardVO> getImgBoardList(Map<String, String> map);
	public boolean registImgBoard(ImgBoardVO ibvo);
}
