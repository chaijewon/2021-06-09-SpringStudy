package com.sist.config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.sist.dao.*;
@Configuration
public class HotelConfig {
   @Bean("ds") // 데이터베이스에 필요한 정보를 저장 => 한번에 전송 
   /*
    *   <bean id="ds" class="com.sist.dao.SeoulDataSource"
	      p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
	      p:username="hr"
	      p:password="happy"
	    />
    */
   public SeoulDataSource seoulDataSource()
   {
	   SeoulDataSource ds=new SeoulDataSource();
	   ds.setUrl("jdbc:oracle:thin:@211.238.142.181:1521:XE");
	   ds.setUsername("hr");
	   ds.setPassword("happy");
	   return ds;
   }
   @Bean("hdao")
   /*
    *  <bean id="ndao" class="com.sist.dao.NatureDAO"
	      c:driverName="oracle.jdbc.driver.OracleDriver"
	      p:ds-ref="ds"
	    />
    */
   public HotelDAO hotelDAO()
   {
	   HotelDAO dao=new HotelDAO("com.sist.dao.NatureDAO");
	   dao.setDs(seoulDataSource());
	   return dao;
   }
}
