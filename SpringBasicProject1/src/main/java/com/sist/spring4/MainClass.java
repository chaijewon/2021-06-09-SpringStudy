package com.sist.spring4;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.spring3.I;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app1.xml");
        // XML 파싱 완료 
        // classpath => src\main\java
        A a=(A)app.getBean("a");// 클래스를 찾는 역할 
        /*
         *  public Object getBean(String key)
            {
	           return map.get(key);
            }
         */
        a.display();
        System.out.println("a:"+a);
        A a1=(A)app.getBean("a");  // 싱글턴 (메모리주소를 한개만 사용)
        a1.display();
        System.out.println("a1:"+a1);
        
        A a2=app.getBean("a",A.class); // 형변환 없이 사용 
        System.out.println("a2:"+a2);
        a2.display();
        
        B b=(B)app.getBean("b");
        b.display();
        
        C c=(C)app.getBean("c");
        c.display();
        /*
         *   클래스 생성 => ~VO (직접)
         *              스프링을 통해서 생성 => (나머지는 Spring)
         *              =================================
         *              XML , Annotation(프로젝트) 
         *   
         */
	}

}
