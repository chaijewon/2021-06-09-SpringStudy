package com.sist.two;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
// 설정을 다로 할 경우에도 중복이 되어 잇으면 안된다 @Bean("mem")
@Configuration
public class MemberConfig {
  @Bean("mem")
  public Member member()
  {
	  Member m=new Member();
	  m.setName("홍길동");
	  m.setSex("남자");
	  m.setAddr("서울");
	  return m; // 멤버변수 초기값을 채워서 저장 
  }
}
