package com.kitri.visitor.dao;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorDAO {
	//vo 작성 후 인터페이스 정의하기 
	
	//전체조회
	public List<VisitorVO> selectVisitors();
	public int insertVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int deleteVisitor(int vno);
	
}
