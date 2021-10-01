package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component("mc")
public class MainClass {
	@Autowired
    private HotelDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 1.스프링 연결
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=app.getBean("mc",MainClass.class);
		List<HotelVO> list=mc.dao.hotelListData();
		for(HotelVO vo:list)
		{
			System.out.println(vo.getName()+"("+vo.getAddress()+")");
		}
		System.out.println("======== 상세보기 =========");
		HotelVO vo=mc.dao.hotelDetailData(10);
		System.out.println("호텔명:"+vo.getName());
		System.out.println("주소:"+vo.getAddress());
		System.out.println("평점:"+vo.getScore());
		/*
		 *   1. SQL문장 
		 *   2. 리턴형 / 매개변수 
		 */
	}

}



