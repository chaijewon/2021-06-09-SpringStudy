package com.sist.main;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 *  스프링에 의해 객체 생성!!
setAddress() Call...
setName() Call...
DI(set메소드) 호출후 값을 주입!!
프로그래머가 호출하는 메소드!!
객체가 소멸한다!!

      1. 컨테이너 호출 => XML전송 / 자바설정파일 전송 
         GenericApplicationContext app=
			new GenericXmlApplicationContext("app.xml");
	     1-1 컨테이너가 하는 역할 
	         1. XML에 등록된 클래스를 메모리 할당 (등록된 클래스의 생성자 호출)
	         2. setXxx() DI를 수행 
	         3. setterDI가 완료됨을 알려준다 (afterPropertiesSet())
	         4. method DI 수행 (init-method)
	  ========================================================
	   2. 프로그래머가 프로그램에 맞게 메소드를 호출해서 작성      
	           프로그램이 끝나면 
	  ========================================================
	   3. 객체 소멸 : app.close(); => gc() (가비지켈렉션)
	   
	   생성 / 소멸 ==> 객체의 생명주기 (빈 라이프사이클)
	   
	  => 사용범위 
	     1. 한개의 메모리만 사용 (기본) => singleton(재사용,메모리누수방지)
	     2. 요청시마다 객체 복제  => prototype(메모리를 따로 만들어 준다)
	     
	     <bean id="aaa" class="A"/>
	     
	     => A a=(A)app.getBean("aaa")
	        A b=(A)app.getBean("aaa")
	        A c=(A)app.getBean("aaa")  
	        =========================  a=b=c (단일객체=싱글턴)
	        
	     <bean id="aaa" class="A" scope="prototype"/>
	        A a=(A)app.getBean("aaa")
	        A b=(A)app.getBean("aaa")
	        A c=(A)app.getBean("aaa") 
	        
	              다중객체 (객체복제=> Object => clone)
			
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 컨테이너 ==> 클래스 관리하는 영역 
		GenericApplicationContext app=
			new GenericXmlApplicationContext("app.xml");
		MyDAO m=(MyDAO)app.getBean("md");
		// 프로그래머가 활용 
		m.display();
		// 종료
		app.close();
	}

}
