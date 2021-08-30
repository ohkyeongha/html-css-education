package mybatis.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import mybatis.vo.MemberVO;

public class MemberDAO {
	@Autowired
	private SqlSession sqlSession;
	
	public List<MemberVO> selectMembers(){
		
//		MybatisConnector mc = new MybatisConnector();
//		SqlSessionFactory factory = mc.getInstance();
//		SqlSession sqlSession = factory.openSession();
		
		List<MemberVO> mlist = sqlSession.selectList("member.selectMembers");
//		sqlSession.close();
		return mlist;
	}
	
//	public MemberVO selectMember(String userId) {
//		
//		MybatisConnector mc = new MybatisConnector();
//		SqlSession sqlSession = mc.getInstance().openSession();
//		MemberVO mvo = sqlSession.selectOne("member.selectMember",userId);
//		sqlSession.close();
//		
//		return mvo;
//	}
	public MemberVO selectMember(MemberVO vo) {
		
		MybatisConnector mc = new MybatisConnector();
		SqlSession sqlSession = mc.getInstance().openSession();
		MemberVO mvo = sqlSession.selectOne("member.selectMember", vo);
		sqlSession.close();
		
		return mvo;
	}
	
	public void insertMember(MemberVO mvo) {
		MybatisConnector mc = new MybatisConnector();
		SqlSession sqlSession = mc.getInstance().openSession(false);
		int result = sqlSession.insert("member.insertMember",mvo);
		sqlSession.commit();
		sqlSession.close();
	}
	
	public void updateMember(Map<String, String> map) {
		MybatisConnector mc = new MybatisConnector();
		SqlSession sqlSession = mc.getInstance().openSession(true);
		int result = sqlSession.update("member.updateMember",map);
		sqlSession.close();
	}
//	public void updateMember(MemberVO mvo) {
//		MybatisConnector mc = new MybatisConnector();
//		SqlSession sqlSession = mc.getInstance().openSession(true);
//		int result = sqlSession.update("member.updateMember",mvo);
//		sqlSession.close();
//	}
	
	public void deleteMember(String userId) {
		MybatisConnector mc = new MybatisConnector();
		SqlSession sqlSession = mc.getInstance().openSession(true);
		int result = sqlSession.delete("member.deleteMember",userId);
		sqlSession.close();
	}
}
