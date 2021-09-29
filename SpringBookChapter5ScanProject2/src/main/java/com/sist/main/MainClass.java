package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
// <bean id="mc" class="com.sist.main.MainClass"/>
@Component("mc")
public class MainClass {
	@Autowired
    private FoodCategoryDAO fdao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=(MainClass)app.getBean("mc");
        List<FoodCategoryVO> list=mc.fdao.categoryListData();
        for(FoodCategoryVO vo:list)
        {
        	System.out.println(vo.getCno());
        	System.out.println(vo.getTitle());
        	System.out.println(vo.getSubject());
        	System.out.println("===============================");
        }
	}

}
