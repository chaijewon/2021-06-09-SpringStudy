package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
// 필요한 클래스는 스프링에 등록 => 필요한 위치에서는 스프링에 등록된 클래스만 사용한다 
public class MainClass {
    private FoodDAO dao;
    // p:dao-ref="dao" ==> mc.setDao() => c:(생성자에 채운다)  , p:setXxx()
	public void setDao(FoodDAO dao) {
		this.dao = dao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		System.out.print("구 입력:");
		String gu=scan.next();
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app.xml");
        //MainClass mc=new MainClass();//MainClass => 반드시 스프링에 저장된 MainClass
        MainClass mc=(MainClass)app.getBean("mc");
        // => new 사용하는 것은 ~VO => 스프링에 저장된 객체를 얻어서 사용 
        List<FoodVO> list=mc.dao.foodListData();//NullPointerException발생
        for(FoodVO vo:list)
        {
        	System.out.println("맛집명:"+vo.getName());
        	System.out.println("주소:"+vo.getAddress());
        	System.out.println("전화:"+vo.getTel());
        	System.out.println("===================================");
        }
        
	}

}
