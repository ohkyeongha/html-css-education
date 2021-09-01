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

}
