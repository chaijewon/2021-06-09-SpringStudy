package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sist.dao.MusicDAO;

// 설정 (클래스 등록) => app.xml
@Configuration
public class MusicConfig {
  /*
   *   <bean id="dao" class="com.sist.dao.MusicDAO"
       c:driverName="oracle.jdbc.driver.OracleDriver"
       p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
       p:username="hr"
       p:password="happy"
    />
   */
	// bean id="dao"
	@Bean("dao")
	// => properties파일 => 정보 => 읽어서 출력 
	public MusicDAO musicDAO()
	{
		MusicDAO dao=new MusicDAO("oracle.jdbc.driver.OracleDriver");
		dao.setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
		dao.setUsername("hr");
		dao.setPassword("happy");
		return dao;
	}
}
