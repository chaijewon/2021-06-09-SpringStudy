package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	@Autowired // 자동 주입 (스프링에서 찾아서 객체주소를 넘겨준다) 95page
	// instanceof => 객체를 찾는다 
    private EmpDAO dao; //주소값이 대입 => 클래스 객체주소 (일반변수는 사용할 수 없다)
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        System.out.println(mc.dao);
        List<EmpVO> list=mc.dao.empListData();
        // 출력 
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getDvo().getDname()+" "
        			+vo.getDvo().getLoc());
        }
	}
}






