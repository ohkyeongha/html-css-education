package com.kitri.visitor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.kitri.visitor.dao.VisitorDAO;
import com.kitri.visitor.vo.VisitorVO;

//서비스 인터페이스 정의 후 VisitorServiceImpl 생성
@Service
public class VisitorServiceImpl implements VisitorService{

	@Autowired
	private VisitorDAO vdao;
	
	PlatformTransactionManager transactionManager;
	
	@Override
	public List<VisitorVO> searchVisitors() {
		return vdao.selectVisitors();
	}

	@Override
	public int registVisitor(VisitorVO vo) {
		
		TransactionStatus status = transactionManager.getTransaction(new DefaultTransactionDefinition());
		
		try {
			vdao.insertVisitor(vo);
			vo.setContent("내용 수정");
			vo.setVno(1);
			vdao.updateVisitor(vo);
			transactionManager.commit(status);
			
		} catch (Exception e) {
			e.printStackTrace();
			transactionManager.rollback(status);
		}
		
		return 0;
	}

	@Override
	public int updateVisitor(VisitorVO vo) {
		return vdao.updateVisitor(vo);
	}

	@Override
	public int deleteVisitor(int vno) {
		return vdao.deleteVisitor(vno);
	}

}
