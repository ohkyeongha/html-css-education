package spring.aop.board;

import org.springframework.stereotype.Component;

//@Component
public class BoardDAO {
	public void selectBoard() {
		System.out.println("�Խ��� �� ��ȸ");
	}
	public void insertBoard(int bno) {
		System.out.println(+bno+"�� �Խñ� ���");
	}
	public void updateBoard(int bno, String update) {
		System.out.println(bno + "�� ����: '" + update + "' ����");
	}
	public void deleteBoard(int bno) {
		System.out.println(bno + "�� �Խñ� ����");
	}
}
