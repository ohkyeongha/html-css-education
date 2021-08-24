package spring.di.log;

import org.springframework.stereotype.Component;

@Component("normal")
public class NormalLog implements Log{
	
	private BoardDAO dao;
	
	public NormalLog() {}
	
	public NormalLog(BoardDAO dao) {
		this.dao = dao;
	}

	@Override
	public void printLog(String msg) {
		System.out.println("[Log] " + msg);
	}

}
