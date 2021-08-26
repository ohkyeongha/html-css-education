package com.kitri.visitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.kitri.visitor.dao.VisitorDAO;
import com.kitri.visitor.vo.VisitorVO;

@Service
public class VisitorServiceImpl implements VisitorService{

	@Autowired
	private VisitorDAO vdao;
	
	@Override
	public List<VisitorVO> searchVisitor() {
		return vdao.selectVisitors();
	}

	@Override
	public int regestVisitor(VisitorVO vvo) {
		
		return 0;
	}

	@Override
	public int updateVisitor(VisitorVO vvo) {
		
		return 0;
	}

	@Override
	public int removeVisitor(int vno) {
		
		return 0;
	}
	
}
