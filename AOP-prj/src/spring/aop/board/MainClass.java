package spring.aop.board;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		GenericXmlApplicationContext context = new GenericXmlApplicationContext();
		context.load("spring/aop/config/board-aop-config.xml");
		context.refresh();
		
		BoardDAO bdao = context.getBean("boardDAO", BoardDAO.class);
		bdao.selectBoard();
		bdao.insertBoard(1);
		bdao.updateBoard(1, "수정된 내용");
		bdao.deleteBoard(1);
		
		
		context.close();
	}

}
