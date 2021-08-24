package spring.di.log;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("bdao")
public class BoardDAO {
	
	@Autowired
	@Qualifier("timestemp")
//	@Qualifier("normal")
	private Log log;
	
	public void setLog(Log log) {
		this.log = log;
	}
	
	public BoardDAO() {}

	//������ ����
	public BoardDAO(Log log) {
		this.log = log;
	}

	public void selectBoard() {
		log.printLog("�Խ��� �� ��ȸ");
	}
	
	public void insertBoard() {
		log.printLog("�Խ��� �� ���");
	}
}
