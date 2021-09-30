package com.sist.config;

import org.apache.commons.dbcp.BasicDataSource;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;

/*
 *   <!-- 사용자 정의 클래스 올리기 -->
    <context:component-scan base-package="com.sist.*"/>
    <!-- 대상 추출 
        @Component, 
        @Repository, 
        @Service, 
        @Controller,
        @RestController,
        @ControllerAdvice, 
        @Configuration 
     -->
     <!-- 라이브러리는 등록  -->
     <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
     />
     <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
       p:configLocation="classpath:Config.xml"
       p:dataSource-ref="ds"
     />
 */
@Configuration
// <context:component-scan base-package="com.sist.*"/>
// XML=>Annotation (순수자바만 코딩)
@ComponentScan(basePackages={"com.sist.*"})
public class StudentConfig {
   /*
    *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
       p:driverClassName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
     />
    */
	@Bean("ds") //bean id="ds"
	public BasicDataSource basicDataSource()
	{
		// class="org.apache.commons.dbcp.BasicDataSource"
		BasicDataSource ds=new BasicDataSource();
		/*
		 *     p:driverClassName="oracle.jdbc.driver.OracleDriver"
		       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
		       p:username="hr"
		       p:password="happy"
		 */
		ds.setDriverClassName("oracle.jdbc.driver.OracleDriver");
		ds.setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
		ds.setUsername("hr");
		ds.setPassword("happy");
		return ds;
	}
	/*
	 *  <bean id="ssf" class="org.mybatis.spring.SqlSessionFactoryBean"
         p:configLocation="classpath:Config.xml"
         p:dataSource-ref="ds"
       />
	 */
	@Bean("ssf")
	public SqlSessionFactory sqlSessionFactory() throws Exception
	{
		SqlSessionFactoryBean ssf=new SqlSessionFactoryBean();
		/*
		 *  p:configLocation="classpath:Config.xml"
            p:dataSource-ref="ds"
		 */
		ssf.setDataSource(basicDataSource());
		//getConnection()/disConnection() : 오라클 연결/닫기
		// SQL문장을 읽어서 처리후에 값을 저장 (PreparedStatement/ResultSet)
		Resource res=new ClassPathResource("Config.xml");
		ssf.setConfigLocation(res);
		return ssf.getObject();
	}
}





