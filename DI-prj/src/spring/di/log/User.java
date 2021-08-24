package spring.di.log;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import config.BoardConfig;

public class User {

	public static void main(String[] args) {
		AbstractApplicationContext context = new GenericXmlApplicationContext("config/board-config.xml"); //xml
//		AbstractApplicationContext context = new AnnotationConfigApplicationContext(BoardConfig.class);
//		BoardDAO dao = (BoardDAO)context.getBean("dao");
		BoardDAO dao = (BoardDAO)context.getBean("bdao");
		
		dao.insertBoard();
		dao.selectBoard();
		
		context.close();
	}

}
