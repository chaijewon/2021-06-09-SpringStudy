package com.sist.main;
import java.util.*;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
/*
 *   클래스등록 100개 
 *   => for문 100번 수행 
 *   => map.get("dao")
 *   
 *   @Autowired(required=false) => 존재하지 않는 경우
 *   @Autowired(required=true)  => 반드시 존재 
 *   ===== 반드시 등록된 경우에서 처리요청 
 *   
 *   new를 사용하면 안된다 
 *   => 스프링에 등록된 클래스만 사용 (getBean())
 */
public class MainClass {
	@Autowired
	@Qualifier("dao") // 115페이지 
	//@Resource(name="dao") // 1.8이후에서 사용이 안됨
	// sts => 3.9 (window,mac)=> 11이상  , 3.8(X)=>1.8
	// 1.8 => sun , 1.9 ~ 오라클
	// 특정 객체를 지정할 경우에 사용 (속도가 빠르다)
    private EmpDAO dao;// 스프링에서 메모리 할당 dao의 주소를 자동 주입
	// 문제점 : OOP파괴 (캡슐화) => private의 의미가 없어졌다 
	// @Autowired => 클래스객체 주소만 활용 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        /*
         *   지역변수 => 매개변수를 이용해서 전송 
         *   전역변수 => 필요한 위치에서 언제든 사용이 가능 
         */
		// XML파싱 요청 
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		//MainClass mc=new MainClass(); 자동주입 
		// 자동주입 => 반드시 스프링에서 클래스관리 
		MainClass mc=(MainClass)app.getBean("mc");
		mc.empListData();
		System.out.println("=============");
		mc.empDetailData(7788);
	}
	public void empListData()
	{
		List<EmpVO> list=dao.empListData();
		for(EmpVO vo:list)
		{
			System.out.println("사번:"+vo.getEmpno());
			System.out.println("이름:"+vo.getEname());
			System.out.println("직위:"+vo.getJob());
			System.out.println("입사일:"+vo.getHiredate());
			System.out.println("급여:"+vo.getSal());
		}
	}
	public void empDetailData(int empno)
	{
		EmpVO vo=dao.empDetailData(empno);
		System.out.println("사번:"+vo.getEmpno());
		System.out.println("이름:"+vo.getEname());
		System.out.println("직위:"+vo.getJob());
		System.out.println("입사일:"+vo.getHiredate());
		System.out.println("급여:"+vo.getSal());
	}

}





