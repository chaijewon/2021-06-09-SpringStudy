package com.sist.main5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// 설정 파일은 프로그램에서 한번만 읽어간다 => 등록된 클래스를 저장한후에 대기 
@Configuration
public class SawonConfig {
   //<bean id="sa" class="com.sist.main.Sawon"/>
   @Bean("sa")
   public Sawon sawon()
   {
	   return new Sawon();
   }
}
