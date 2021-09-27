package com.sist.main2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Configuration;
// 경로 (자바외 파일)
// 자바 (import / com.sist.main2.클래스명)
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 5버전에서 사용되는 컨테이너명 AnnotationConfigApplicationContext
		// 두개 이상 XML 
		// @Configuration 여러개 
		// DI (멤버변수의 초기화) => chapter 3장 
        AnnotationConfigApplicationContext app=
        		 new AnnotationConfigApplicationContext(BeanConfig.class);
        Member m=(Member)app.getBean("mem");
        // 키명은 => 클래스
        m.setName("홍길동");
        m.setSex("남자");
        m.print();
        
	}

}
