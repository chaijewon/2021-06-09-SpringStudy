package com.sist.main;

import java.util.List;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.LocationDAO;
import com.sist.dao.LocationVO;

public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ApplicationContext app=
	        	new ClassPathXmlApplicationContext("app.xml");
	        LocationDAO hdao=(LocationDAO)app.getBean("ldao");
	        List<LocationVO> list=hdao.locationListData();
	        for(LocationVO vo:list)
	        {
	        	System.out.println(vo.getTitle());
	        }
	        System.out.println("======= 상세보기 ========");
	        LocationVO vo=hdao.locationDetailData(1);
	        System.out.println("번호:"+vo.getNo());
	        System.out.println("명소명:"+vo.getTitle());
	        System.out.println("주소:"+vo.getAddress());
	        
	        Scanner scan=new Scanner(System.in);
	        System.out.print("명소명:");
	        String name=scan.next();
	        List<LocationVO> hList=hdao.locationFindData(name);
	        for(LocationVO hvo:hList)
	        {
	        	System.out.println(hvo.getTitle());
	        }
	        System.out.println("========= 페이지 나누기 ==========");
	        int curpage=1;
	        int totalpage=hdao.locationTotalPage();
	        System.out.println("현재페이지:"+curpage);
	        System.out.println("총페이지:"+totalpage);
	        System.out.print("페이지 입력:");
	        curpage=scan.nextInt();
	        hList.clear();// 저장된 데이터 지워서 사용 
	        hList=hdao.locationPageingData(curpage);
	        for(LocationVO hvo:hList)
	        {
	        	System.out.println(hvo.getTitle());
	        }
	        
	}

}
