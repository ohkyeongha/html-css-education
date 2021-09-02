package com.kitri.mini.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.mini.user.dao.ImgUserDAO;
import com.kitri.mini.user.vo.ImgUserVO;

@Service
public class ImgUserServiceImpl implements ImgUserService{

	@Autowired
	private ImgUserDAO imgUserDAO;
	
	@Override
	public boolean loginCheckImgUser(ImgUserVO iuvo) {
		
		ImgUserVO vo = imgUserDAO.selectImgUser(iuvo);
		boolean loginFlag = false;
		if(vo!=null) {
			loginFlag = true;
		}
		
		return loginFlag;
	}

	@Override
	public boolean idCheck(String id) {
		
		int result = imgUserDAO.selectIdCheck(id);
		boolean idCheckFlag = false;
		if(result!=0) {
			//중복된 id 존재
			idCheckFlag = false;
		} else {
			//id 사용가능
			idCheckFlag = true;
		}
		return idCheckFlag;
	}

	@Override
	public boolean registImgUser(ImgUserVO iuvo) {
		
		int result = imgUserDAO.insertImgUser(iuvo);
		boolean regstCheckFlag = false;
		if(result !=0) {
			regstCheckFlag = true;
		}
		
		return regstCheckFlag;
	}

}
