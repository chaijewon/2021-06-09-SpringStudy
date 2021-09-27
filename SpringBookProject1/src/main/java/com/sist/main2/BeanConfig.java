package com.sist.main2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
// 자동 ID => MovieDAO ==> movieDAO (id를 지정하지 않은 경우) 
@Configuration
public class BeanConfig {
   // <bean id="mem" class="com.sist.main2.Member" scope="prototype">
   // 스프링5버전 (보안=>XML대신 순수하게 자바로 셋팅) 
   @Bean("mem")
   public Member member()
   {
	   return new Member();
   }
}
