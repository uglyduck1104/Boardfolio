package com.uglyduck.webapp;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MybatisTest {
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Inject
	private SqlSessionFactory sessionFactory;
	
	@Test
	public void testSessionFactory() {
		logger.info("\nSession Factory: {}", sessionFactory);
	}
	
	@Test
	public void testSqlSession() {
		try(SqlSession session = sessionFactory.openSession()){
			logger.info("\nSql Session: {}", session);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
