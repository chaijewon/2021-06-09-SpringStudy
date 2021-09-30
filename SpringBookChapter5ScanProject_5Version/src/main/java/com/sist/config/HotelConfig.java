package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

// 클래스을 등록하는 설정파일 => 스프링에 알려준다 
// 스프링이 인식할 수 있는 구분 => 어노테이션 (5버전:보안이 좋다=보안을 중심)/ XML(4버전:보안이 취약)
// 자바 => 컴파일(.class:배포)
// C언어 ==> .exe
/*
 *   <context:component-scan base-package="com.sist.*"/>
    <!-- 
        @Component, 
        @Repository, 
        @Service, 
        @Controller, 
        @RestController, 
        @ControllerAdvice, => AOP
        @Configuration => 순수자바 
     -->
     <!-- 라이브러리 : 상속을 받아서 처리 (XML) -->
     <!-- 오라클 정보를 모아준다  -->
     <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
     />
     <!-- MyBatis로 연결 -->
     <bean id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
       p:configLocation="classpath:Config.xml"
     />
 */
@Configuration
// <context:component-scan base-package="com.sist.*"/>
@ComponentScan(basePackages={"com.sist.*"})
public class HotelConfig {
    /*
     * <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
     />
     */
	// 자동화(X) ==> 설정(프로그래머) => 설정된 파일 관리 
	@Bean("ds")
	public BasicDataSource basicDataSource()
	{
		BasicDataSource ds=new BasicDataSource();
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	
	/*
	 * <bean id="ssf"
       class="org.mybatis.spring.SqlSessionFactoryBean"
       p:dataSource-ref="ds"
       p:configLocation="classpath:Config.xml"
     />
	 */
	// 마이바티스 (XML/Annotation) => PL/SQL , INDEX => DML,VIEW,SEQUENCE
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		ssf.setDataSource(basicDataSource());
		// 오라클 정보 => getConnection(),disConnection()
		// SQL문장 => PreparedStatement/ResultSet
		// classpath => src/main/java => 스프링에서는 경로를 자동으로 인식
		Resource res=new ClassPathResource("Config.xml");
		// Web => 경로 (로컬 = c:\\~~) 
		// resource : 파일정보
		ssf.setConfigLocation(res);
		
		return ssf.getObject(); //컴파일 예외 (반드시 예외 처리를 한다)
	}
	// 자바 ==> 오라클문제(자바 전반적으로 유료화) : spring(코틀린)
}







