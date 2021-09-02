package com.kitri.mini.user.dao;

import com.kitri.mini.user.vo.ImgUserVO;

public interface ImgUserDAO {
	public ImgUserVO selectImgUser(ImgUserVO iuvo);
	public int selectIdCheck(String id);
	public int insertImgUser(ImgUserVO iuvo);
}
