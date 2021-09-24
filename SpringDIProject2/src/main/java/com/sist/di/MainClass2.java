package com.sist.di;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 객체 생성시(메모리 할당)에 생성자의 매개변수에 값을 채워서 객체를 생성후 저장
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app3.xml");
		Member m1=(Member)app.getBean("mem1");
		/*
		 *   <bean id="mem1" class="com.sist.di.Member">
		       <constructor-arg value="홍길동" index="0"/><!-- index는 생략이 가능 -->
		       <constructor-arg value="남자" index="1"/>
		       <constructor-arg value="30" index="2"/>
		     </bean>
		     
		     Member mem1=new Member("홍길동","남자",30)
		     
		     <bean id="mem3" class="com.sist.di.Member"
			       p:name="박문수"
			       p:sex="남자"
			       p:age="30"
			     />
			   Member mem3=new Member();
			   mem3.setName("박문수");
			   mem3.setSex("남자");
			   mem3.setAge(30)
		 */
		System.out.println("m1:name="+m1.getName());
		System.out.println("m1:sex="+m1.getSex());
		System.out.println("m1:age="+m1.getAge());
		System.out.println("================");
		
		Member m2=(Member)app.getBean("mem2");
		/*
		 *   <bean id="mem2" class="com.sist.di.Member"
		       c:name="심청이"
		       c:sex="여자"
		       c:age="25"
		     />
		      * 
		      new Member("심청이","여자",25)
		 */
		System.out.println("m2:name="+m2.getName());
		System.out.println("m2:sex="+m2.getSex());
		System.out.println("m2:age="+m2.getAge());
		System.out.println("================");
		
		Member m3=(Member)app.getBean("mem3");
		/*
		 *   <bean id="mem3" class="com.sist.di.Member"
			       c:_0="박문수"
			       c:_1="남자"
			       c:_2="33"
			     />
			  new Member("박문수","남자",33)
		 */
		System.out.println("m3:name="+m3.getName());
		System.out.println("m3:sex="+m3.getSex());
		System.out.println("m3:age="+m3.getAge());
		System.out.println("================");
	}

}
