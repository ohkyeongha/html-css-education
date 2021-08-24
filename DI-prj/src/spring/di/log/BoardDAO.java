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

	//생성자 주입
	public BoardDAO(Log log) {
		this.log = log;
	}

	public void selectBoard() {
		log.printLog("게시판 글 조회");
	}
	
	public void insertBoard() {
		log.printLog("게시판 글 등록");
	}
}
