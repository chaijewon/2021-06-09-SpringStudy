package com.sist.auto;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
	/*
	 *  <bean id="edao" class="com.sist.auto.EmpDAO"/> => DAO
        <bean id="ddao" class="com.sist.auto.DeptDAO"/> => DAO
        
               같은 유형의 클래스 (@Autowired => @Resource)
               = 인터페이스 구현한 클래스가 여러개인 경우 
               = 같은 클래스 상속이 있는 경우 
        => 어노테이션 (스프링)
           => 적어도 70개 (유형성 검사)
	 */
	//@Autowired
	//@Qualifier("edao") //특정객체를 지정할 때 
	@Resource(name="ddao") // @Autowired+@Qualifier("edao")
	// 같은 유형의 클래스가 있는 경우 @Autowired는 처리할 수 없다 
	// 가장 많이 어노테이션 
    private DAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app1.xml");
        // <bean id="mc" class="com.sist.auto.MainClass"/>
        // 스프링에서 생성된 객체를 가지고 온다 
        MainClass mc=(MainClass)app.getBean("mc");
        mc.dao.getConnection();
        mc.dao.disConnection();
	}

}
