package spring.di.log;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Component;

@Component("timestemp")
public class TimeStempLog implements Log{

	private BoardDAO dao;
	
	public TimeStempLog() {}
	
	public TimeStempLog(BoardDAO dao) {
		this.dao = dao;
	}
	
	@Override
	public void printLog(String msg) {
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		String time = sdf.format(now);
		System.out.println("[Log] " + time + " " + msg);
	}

}
