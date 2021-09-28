package com.sist.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// <bean> @Bean ==> 스프링에서 메모리 할당 관리하는 대상의 클래스 
@Configuration
public class SawonConfig {
  @Bean("sa")
  public Sawon sawon()
  {
	  Sawon s=new Sawon();
	  s.setName("박문수");
	  s.setDept("개발부");
	  s.setLoc("부산");
	  return s;
  }
}
