package com.kitri.mini.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.mini.user.dao.NaverUserDAO;
import com.kitri.mini.user.vo.NaverUserVO;

@Service
public class NaverUserServiceImpl implements NaverUserService{

	@Autowired
	private NaverUserDAO naverUserDAO;
	
	@Override
	public NaverUserVO registNaverUser(NaverUserVO nuvo) {
		
		if(nuvo.getBirthday()==null) {
			nuvo.setBirthday("");
		}
		if(nuvo.getMobile()==null) {
			nuvo.setMobile("");
		}
		NaverUserVO vo = naverUserDAO.selectNaverUser(nuvo.getEmail());
		//이미 등록이 되어있는지 조회
		if(vo == null) {
			//등록이 안되어있으면 등록하고 로그인/되어있으면 등록 없이 로그인
			naverUserDAO.insertNaverUser(nuvo);
			vo = nuvo;
		} 
		
		return vo;
	}
	
	
}
