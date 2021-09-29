package com.sist.mgr;

import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.stereotype.Component;

/*
 *  <bean id="ds" class="org.apache.commons.dbcp.BasicDataSource"
      p:driverClassName="#{db['driver']}"
      p:url="#{db['url']}"
      p:username="#{db['username']}"
      p:password="#{db['password']}"
    />
 */
@Component("ds")
public class MyBasicDataSource extends BasicDataSource{
   public MyBasicDataSource()
   {
	   // setter에 값을 채운다
	   setDriverClassName("oracle.jdbc.driver.OracleDriver");
	   setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
	   setUsername("hr");
	   setPassword("happy");
   }
}







