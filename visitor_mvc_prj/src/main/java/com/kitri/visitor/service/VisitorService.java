package com.kitri.visitor.service;

import java.util.List;

import com.kitri.visitor.vo.VisitorVO;

public interface VisitorService {
	public List<VisitorVO> searchVisitor();
	public int regestVisitor(VisitorVO vvo);
	public int updateVisitor(VisitorVO vvo);
	public int removeVisitor(int vno);
}
