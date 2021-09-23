package com.sist.dao;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 컨테이너에 XML을 전송 => 파싱 => 메모리 할당 => 할당된 객체를 Map에 저장한다
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app2.xml");
		EmpDAO dao=app.getBean("dao",EmpDAO.class);// 형변환 없이 사용(제네릭스)
		
		List<EmpVO> list=dao.empListData();
		System.out.println("========사원목록========");
		for(EmpVO vo:list)
		{
			System.out.println("사번"+vo.getEmpno());
			System.out.println("이름:"+vo.getEname());
			System.out.println("직위:"+vo.getJob());
			System.out.println("=================");
		}
		
	}

}
