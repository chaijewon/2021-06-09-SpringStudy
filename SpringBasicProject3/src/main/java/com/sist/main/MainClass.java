package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        FoodDAO dao=(FoodDAO)app.getBean("dao");
        List<FoodVO> list=dao.foodListData();
        for(FoodVO vo:list)
        {
        	System.out.println("맛집명:"+vo.getName());
        	System.out.println("주소:"+vo.getAddress());
        	System.out.println("전화:"+vo.getTel());
        	System.out.println("========================================");
        }
        System.out.println("상세보기");
        FoodVO vo=dao.foodDetailData(1);
        System.out.println("맛집명:"+vo.getName());
    	System.out.println("주소:"+vo.getAddress());
    	System.out.println("전화:"+vo.getTel());
	}

}
