package com.kitri.mini.board.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.mini.board.dao.ImgBoardDAO;
import com.kitri.mini.board.vo.ImgBoardVO;

@Service
public class ImgBoardServiceImpl implements ImgBoardService{

	@Autowired
	private ImgBoardDAO imgBoardDAO;
	
	@Override
	public List<ImgBoardVO> getImgBoardList(Map<String, String> map) {
		
		return imgBoardDAO.selectImgBoards(map);
	}

	@Override
	public boolean registImgBoard(ImgBoardVO ibvo) {
		int result = imgBoardDAO.insertImgBoard(ibvo);
		boolean registFlag = false;
		
		if(result!=0) {
			registFlag=true;
		}
		
		return registFlag;
	}

}
