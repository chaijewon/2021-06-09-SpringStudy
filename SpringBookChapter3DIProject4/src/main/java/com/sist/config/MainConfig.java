package com.sist.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

import com.sist.dao.HotelDAO;
import com.sist.dao.LocationDAO;
import com.sist.dao.NatureDAO;
import com.sist.dao.SeoulDataSource;
import com.sist.main.MainClass;
import com.sist.main.MainClass2;

@Configuration
//@Import({HotelConfig.class,NatureConfig.class,LocationConfig.class})
public class MainConfig {
	
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
	   
	   @Bean("ndao")
	   /*
	    *  <bean id="ndao" class="com.sist.dao.NatureDAO"
		      c:driverName="oracle.jdbc.driver.OracleDriver"
		      p:ds-ref="ds"
		    />
	    */
	   public NatureDAO natureDAO()
	   {
		   NatureDAO dao=new NatureDAO("com.sist.dao.NatureDAO");
		   dao.setDs(seoulDataSource());
		   return dao;
	   }
	   
	   @Bean("ldao")
	   /*
	    *  <bean id="ndao" class="com.sist.dao.NatureDAO"
		      c:driverName="oracle.jdbc.driver.OracleDriver"
		      p:ds-ref="ds"
		    />
	    */
	   public LocationDAO locationDAO()
	   {
		   LocationDAO dao=new LocationDAO("com.sist.dao.NatureDAO");
		   dao.setDs(seoulDataSource());
		   return dao;
	   }
	   
	   @Bean("mc")
	   public MainClass2 mainClass()
	   {
		   MainClass2 mc=new MainClass2();
		   mc.setHdao(hotelDAO());
		   mc.setLdao(locationDAO());
		   mc.setNdao(natureDAO());
		   return mc;
	   }
}
