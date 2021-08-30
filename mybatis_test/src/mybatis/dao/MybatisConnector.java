package mybatis.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MybatisConnector {
//	private static SqlSessionFactory factory = null;
	
	public SqlSessionFactory getInstance() {
		SqlSessionFactory factory = null;
		Reader reader = null;
		try {
			reader = Resources.getResourceAsReader("mybatis/config/mybatis-config.xml");
			factory = new  SqlSessionFactoryBuilder().build(reader);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return factory;
	}
	
}
