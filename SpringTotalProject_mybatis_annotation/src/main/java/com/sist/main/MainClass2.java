package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component
public class MainClass2 {
	@Autowired
    private LocationDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass2 mc=(MainClass2)app.getBean("mainClass2");
		List<LocationVO> list=mc.dao.locationListData();
		for(LocationVO vo:list)
		{
			System.out.println("명소명:"+vo.getTitle());
			System.out.println("소개:"+vo.getMsg());
			System.out.println("위치:"+vo.getAddress());
			System.out.println("==========================================");
		}
		System.out.println("============ 상세보기 ===========");
		LocationVO vo=mc.dao.locationDetailData(20);
		System.out.println("명소명:"+vo.getTitle());
		System.out.println("소개:"+vo.getMsg());
		System.out.println("위치:"+vo.getAddress());
	}

}
