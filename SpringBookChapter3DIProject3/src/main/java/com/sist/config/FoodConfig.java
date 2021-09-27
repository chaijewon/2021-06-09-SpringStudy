package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import java.util.*;
import com.sist.dao.*;
import com.sist.main.MainClass;
import com.sist.main.MainClass2;
@Configuration
public class FoodConfig {
   /*
    *   <bean id="dao" class="com.sist.dao.FoodDAO"
	       c:driverName="oracle.jdbc.driver.OracleDriver"
	       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
	       p:username="hr"
	       p:password="happy"
	    />
    */
	@Bean("dao")
	public FoodDAO foodDAO()
	{
		// DI (변수 주입) 
		FoodDAO dao=new FoodDAO("oracle.jdbc.driver.OracleDriver");
		// 생성자 DI
		//////////////////////////////////////////////////////
		dao.setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
		dao.setUsername("hr");
		dao.setPassword("happy");
		//////////////////////////setter DI
		return dao;
	}
	/*
	 * <bean id="mc" class="com.sist.main.MainClass"
        p:dao-ref="dao"
       />
	 */
	// id가 없다 => 자동으로 id가 부여 (클래스명이 id가 된다 , 단 첫자가 소문자)
	//  MainClass ==> mainClass
	// Sawon => sawon , FoodDAO => foodDAO
	// 각 빈마다 id는 한개만 존재한다 
	@Bean("mc")
	@Scope("prototype") // 극히 드물다 (싱글턴) : 메모리 누수현상을 방지 
	public MainClass2 mainClass()
	{
		MainClass2 mc=new MainClass2();
		mc.setDao(foodDAO());
		return mc;
	}
	// 80page DI방식 => 생성자방식
	// 84page 세터메소드 방식
	/*
	 *   설정파일이 여러개일 경우 
	 *   xml
	 *   ApplicationContext app=
	 *     new ClassPathXmlApplicationContext(String xml)
	 *   ApplicationContext app=
	 *     new ClassPathXmlApplicationContext(String[] xml)
	 *     
	 *   ApplicationContext app=
	 *     new ClassPathXmlApplicationContext(String regex)
	 *     => app.xml,app1.xml,app2.xml...       |
	 *                                          app*.xml
	 *     => 패턴을 사용 => application-context.xml
	 *                   application-datasource.xml 
	 *                   application-*.xml
	 *   config
	 *   AnnotationConfigApplication app=
	 *     new AnnotationConfigApplication(Class cls) => A.class
	 *   AnnotationConfigApplication app=
	 *     new AnnotationConfigApplication(Class[] cls) => A.class
	 *     
	 *   XML을 사용 
	 *     |
	 *     ApplicationContext
	 *     GenericApplicationContext
	 *   Annotation
	 *     |
	 *    AnnotationConfigApplication
	 *    ===============================7장 기본 과정 
	 *       8장 => 데이터베이스 
	 *       9장 
	 *   WEB 
	 *     |
	 *    WebApplicationContext (MVC)
	 *     
	 */
}
