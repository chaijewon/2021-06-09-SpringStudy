package com.sist.main;
/*
 *     스프링 : 클래스 관리 라이브러리 
 *            ========
 *             관리할 클래스를 모아 준다 (컨테이너)
 *             Container => 제공 
 *             ================
 *             ApplicationContext
 *             GenericApplicationContext(닫기 기능)
 *             AnnotationConfigApplicationContext(자바설정 파일)
 *             WebApplicationContext (MVC)
 *             ==> 기능 :
 *                 1. 클래스 메모리 할당 (리플렉션)
 *                    Class.forName("클래스명")
 *                 2. DI => 주입 (멤버변수 초기화)
 *                       => 생성자 , setXxx()
 *                          ===== 멤버변수의 초기화를 담당하는 함수
 *                =========================================
 *                 3. 반복적인 소스를 줄여줄 수 있다 (AOP)
 *                    공통모듈 / 핵심모듈 
 *                            ====== 중심으로 핵심만 코딩
 *                    =>DAO : 모든 메소드 => getConnection()
 *                                       es.printStackTrace()
 *                                       disConnection()
 *                    =>1/3  => Mybatis (1/5) 10000줄 => 2000줄
 *                 4. MVC(스프링) 
 *                 
 *        = 등록된 클래스 : 메모리 할당 
 *                      ======== 한개 메모리 사용 (singleton)
 *                      ======== 여러개 메모리 사용 (prototype=clone)
 *                      Sawon s=new Sawon()
 *                      Sawon s1=s;
 *                      Sawon s2=s
 *                      ============== 같은 메모리 제어 (단일 객체)
 *                      
 *                      Sawon s=new Sawon();
 *                      Sawon s1=new sawon();
 *                      Sawon s2=new sawon();
 *                 *** 기억 (스프링에서 설정파일을 등록하면 1번 파싱)
 *                     한번 읽어서 => 메모리 할당 (같은 메모리 공간)
 *                 
 */

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass{
    
	public static void main(String[] args) {
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		/*
		 *   <bean id="b" class="B"
		 *     p:a-ref="a"
		 *   />
		 *   <bean id="a" class="A"
		 *     p:name="홍길동"
		 *   />
		 *   
		 *   public class A
		 *   {
		 *       private String name;
		 *       public void setName(String name)
		 *       {
		 *          this.name=name;
		 *       }
		 *   }
		 *   public class B
		 *   {
		 *       private A a;
		 *       public void setA(A a)
		 *       {
		 *          this.a=a;
		 *       }
		 *   }
		 *   1. 등록된 모든 클래스의 메모리 할당
		 *       A a=new A();
		 *       B b=new B();
		 *   2. DI
		 *      a.setName("")
		 *      b.setA(a)
		 *   3. method-call (init-method,destory-method)
		 *   =========================================== 대기
		 *   4. 프로그래머 작업(필요시마다 저장된 객체주소만 얻어서 사용)
		 *      getBean()
		 *   ===========================================
		 *   5. 소멸
		 */
		Sawon sa1=(Sawon)app.getBean("sa");
		Sawon sa2=(Sawon)app.getBean("sa");
		Sawon sa3=(Sawon)app.getBean("sa");
		Sawon sa4=(Sawon)app.getBean("sa");
		Sawon sa5=(Sawon)app.getBean("sa");//단일객체 (싱글턴)
		System.out.println("sa1="+sa1);
		System.out.println("sa2="+sa2);
		System.out.println("sa3="+sa3);
		System.out.println("sa4="+sa4);
		System.out.println("sa5="+sa5);
		// sa1=sa2=sa3=sa4=sa5 default(싱글턴)
		/*
		 *    48page 컨테이너 종류 (클래스를 등록하면 관리)
		 *    49page 상속도
		 *    ===========
		 *     ApplicationConetext,GenericApplicationContext
		 *      => XML설정 파일 
		 *     AnnotatationConfigApplicationContext(자바 설정파일)
		 *    50page 싱글턴 
		 *    
		 */
		
	}

}
