package com.sist.main;
/*
 *   DI => 스프링을 통해서 멤버변수 초기화 방법 
 *         ==========================
 *         set메소드 이용하는 방식 : setter DI (p:)
 *         생성자를 이용해서 방식 : constructor DI(c:)
 *         
 *         => p:name="" ======> 일반 변수값 (문자열,정수,실수...)
 *            p:name-ref="" ==> 객체주소 
 *         => 라이브러리 객체가 필요한 경우 
 *            BasicDataSource , SqlSessionFactoryBean ...
 *            ViewResolver
 *         => 객체주입 (ref)
 *         => 한개를 설정하면 여러개의 객체에서 사용이 가능 
 *          <bean id="ds" class="com.sist.dao.SeoulDataSource"
		      p:url="jdbc:oracle:thin:@211.238.142.181:1521:XE"
		      p:username="hr"
		      p:password="happy"
		    />
		    <bean id="hdao" class="com.sist.dao.HotelDAO"
		      c:driverName="oracle.jdbc.driver.OracleDriver"
		      p:ds-ref="ds"
		    />
		    <bean id="ndao" class="com.sist.dao.NatureDAO"
		      c:driverName="oracle.jdbc.driver.OracleDriver"
		      p:ds-ref="ds"
		    />
		    <bean id="ldao" class="com.sist.dao.LocationDAO"
		      c:driverName="oracle.jdbc.driver.OracleDriver"
		      p:ds-ref="ds"
		    />
		    
		    메소드 호출 가능 (스프링)
		      = 객체 생성시  => init-method
		      = 객체 소멸시  => destory-method
		      
		  Container : DL / DI
		       DL => 클래스 찾기 (getBean()) , @Autowired , @Resource
		       DI => 초기화 
		    
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
