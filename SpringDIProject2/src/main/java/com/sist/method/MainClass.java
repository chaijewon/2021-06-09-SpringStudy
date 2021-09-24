package com.sist.method;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;
/*
 *         BeanFactory 
 *            |
 *      ApplicationContext 
 *            |
 *     ============================================
 *     |                                          |
 *  GenericApplicationContext(종료)   AnnotationConfigApplicationContext(5.0)
 *  WebApplicationContext(MVC)
 *  
 *  ====> XML에 등록된 클래스를 관리(생성 ~ 소멸)
 *  
 *  DL : 클래스 찾기 (getBean())
 *  DI 
 *  ===
 *    =====================> 이름 ,부서 ,성별 (X) => 오라클
 *    ===============================================
 *    = setter DI => 변수의 초기화 
 *    = 생성자 DI => 변수의 초기화 
 *    
 *      서버 주소 / 오라클 관련 데이터 전송 / 객체 결합 
 *    ===============================================
 *    = 메소드 DI ==> 시작과 동시 , 종료과 동시(destory-method)
 *                  ========
 *                  init-method
 *                  
 *    = 스프링에서 관리 할 클래스 
 *      ====> DAO (여러개 클래스에서 사용이 가능)
 *      ====> Manager(Jsoup,XML파싱) => 외부 웹에서 데이터 읽기 
 *      ====> Service (DAO+DAO) => BI(데이터베이스 통합)
 *      ====> Model
 *      제외 : VO (데이터형으로 사용) 
 *            MainClass : 사용자가 보는 파일 (JSP)
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
         /*ApplicationContext app=
        		 new ClassPathXmlApplicationContext("app4.xml");
        	    => close()를 가지고 있지 않는다 	 
         */
		 GenericApplicationContext app=
				 new GenericXmlApplicationContext("app4.xml");
         Sawon s=(Sawon)app.getBean("sa");
         // 생성자 호출 
         System.out.println("이름:"+s.getName());
         System.out.println("부서:"+s.getDept());
         System.out.println("직위:"+s.getJob());
         app.close();// 컨테이너를 닫으면 스프링에 등록된 모든 객체가 메모리 해제 
	}

}
