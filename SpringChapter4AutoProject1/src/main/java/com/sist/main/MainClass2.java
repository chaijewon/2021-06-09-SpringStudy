package com.sist.main;

import java.util.List;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;

public class MainClass2 {
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		MainClass2 mc=new MainClass2();//주입이 없는 상태 (스프링으로부터 값을 받을 것이 없다)
		EmpDAO dao=(EmpDAO)app.getBean("dao");
		mc.empListData(dao);
		System.out.println("=======");
		mc.empDetailData(dao, 7788);
        // 메소드 여러곳에서 사용하면 => 전역변수 
		// 메소드 한곳에서만 사용 => 지역변수 
	}
	public void empListData(EmpDAO dao)
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
	public void empDetailData(EmpDAO dao,int empno)
	{
		EmpVO vo=dao.empDetailData(empno);
		System.out.println("사번:"+vo.getEmpno());
		System.out.println("이름:"+vo.getEname());
		System.out.println("직위:"+vo.getJob());
		System.out.println("입사일:"+vo.getHiredate());
		System.out.println("급여:"+vo.getSal());
	}

}
