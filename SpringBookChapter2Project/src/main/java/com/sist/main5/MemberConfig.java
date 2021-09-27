package com.sist.main5;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
// XML => bean Configuration file 
// 클래스를 등록하는 파일 => 보안 (Java파일은 => 컴파일된 파일 (Member.class))
/*
 *        ApplicationContext (XML)
 *            |
 *         = GenericApplicationContext(닫기)
 *         = AnnotationConfigApplicationContext(자바로 클래스 등록)
 *         = WebApplicationContext(MVC)
 */
@Configuration
public class MemberConfig {
  // <bean id="mem" class="com.sist.main.Member"/>
  @Bean("mem")
  public Member member()
  {
	  return new Member();
  }
}
// page => 52
// chapter 2장 => 49페이지(컨테이너의 종료)
// 50page => 싱글턴 객체  ==> 단일객체 (메모리를 한개마 사용한다)
// 52page => 프로토타입 범위 ==> 여러개를 복제 한다 (여러개 메모리가 필요시에는 사용)
