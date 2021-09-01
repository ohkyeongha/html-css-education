package com.kitri.mini.user.dao;

import com.kitri.mini.user.vo.NaverUserVO;

public interface NaverUserDAO {
	public NaverUserVO selectNaverUser(String email);
	public int insertNaverUser(NaverUserVO nuvo);
}
