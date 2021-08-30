package com.kitri.visitor.service;
//DAOimpl 작성 후 서비스 인터페이스 정의

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorService { // 일대일 매칭이 어렵기때문에 인터페이스별 메소드명이 달라야함.

	
	public List<VisitorVO> searchVisitors(); // select임 사실

	public int registVisitor(VisitorVO vvo);

	public int updateVisitor(VisitorVO vvo);

	public int deleteVisitor(int vno);

}
