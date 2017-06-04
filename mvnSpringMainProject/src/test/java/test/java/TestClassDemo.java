package test.java;

import static org.junit.Assert.*;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import services.MonService;

public class TestClassDemo {

	private static ClassPathXmlApplicationContext context;
	private static MonService monService;

	@BeforeClass
	public static void setUpBeforeClass() {

		context = new ClassPathXmlApplicationContext("application-context.xml");
		monService = (MonService) context.getBean("monService");
		
		assertNotNull(monService);
		
		
	}

	@Test
	public void testDependencies() {
		BasicDataSource bds;
		bds = (BasicDataSource) context.getBean("dataSource");
		LocalSessionFactoryBean lsf;
		lsf = context.getBean("&sessionFactory", LocalSessionFactoryBean.class);

		HibernateTransactionManager htm;
		htm = (HibernateTransactionManager) context.getBean("transactionManager");

		assertNotNull(bds);
		assertNotNull(lsf);
		assertNotNull(htm);
	}
}