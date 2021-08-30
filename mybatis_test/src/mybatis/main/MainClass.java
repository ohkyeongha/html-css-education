package mybatis.main;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.context.support.GenericXmlApplicationContext;

import mybatis.dao.MemberDAO;
import mybatis.vo.MemberVO;

public class MainClass {

	public static void main(String[] args) {
		
		GenericXmlApplicationContext context = new GenericXmlApplicationContext("mybatis/config/context.xml");
		MemberDAO dao = context.getBean("memberDAO", MemberDAO.class);
		
//		MemberDAO dao = new MemberDAO();
		List<MemberVO> mlist = dao.selectMembers();
		
//		selectMembers
		for (MemberVO vo : mlist) {
//			System.out.println(vo.getUserId() + ", " + vo.getUserPw() + ", " + vo.getEmail());
			System.out.println(vo.getId() + ", " + vo.getPw() + ", " + vo.getEmail());
		}
		
		//selectMember
//		MemberVO vo = new MemberVO();
//		vo.setId("admin");
//		
//		MemberVO mvo = dao.selectMember(vo);
//		System.out.println(mvo.getId() + ", " + mvo.getPw() + ", " + mvo.getEmail());
		
		
//		MemberVO mvo = new MemberVO();
//		mvo.setUserId("user");
//		mvo.setUserPw("qwer");
//		mvo.setEmail("user@mail.com");
//		dao.insertMember(mvo);
//		dao.updateMember(mvo);
//		dao.deleteMember("user");
		
//		HashMap<String, String> map = new HashMap<String, String>();
//		map.put("id", "admin");
//		map.put("pw", "qwer");
//		map.put("email", "admin@email.com");
//		dao.updateMember(map);
	}
	
}
