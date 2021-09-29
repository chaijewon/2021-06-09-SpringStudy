package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
// 메모리 할당
@Component
public class MainClass {
	@Autowired
    private FoodCategoryDAO cdao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        MainClass mc=app.getBean("mainClass",MainClass.class);
        // ID를 설정하지 않는 경우 => default id가 생성 => 클래스명(첫자만 소문자)
        List<FoodCategoryVO> list=mc.cdao.categoryListData();
        for(FoodCategoryVO vo:list)
        {
        	System.out.println("제목:"+vo.getTitle());
        	System.out.println("내용:"+vo.getSubject());
        	System.out.println("============================");
        }
	}

}
