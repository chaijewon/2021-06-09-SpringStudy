package com.sist.main5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class StudentConfig {
  /*
   *   <bean id="std" class="com.sist.main.Student"
	      p:hakbun="1" 
	      p:name="홍길동"
	      p:subject="컴퓨터과"
	    />
   */
	// spring 4버전부터 존재 => 5버전 완전히 변경 
	// XML => 자바로 대체(어노테이션)
	@Bean("std")
	public Student student()
	{
		Student std=new Student();
		std.setHakbun(2);
		std.setName("심청이");
		std.setSubject("경영");
		return std;
	}
}
