package com.sist.constructor5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SawonConfig {
   /*
    *   <bean id="sa" class="com.sist.constructor.Sawon"
	      c:name="박문수"
	      c:dept="개발부"
	      c:job="대리"
	    />
    */
	// bean id="sa"
	@Bean("sa")
	// class="com.sist.constructor.Sawon"
	public Sawon sawon()
	{
		Sawon sa=new Sawon("이순신", "기획부", "부장");
		return sa;
	}
}
