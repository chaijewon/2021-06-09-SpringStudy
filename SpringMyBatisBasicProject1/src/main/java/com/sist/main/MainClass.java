package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        	new ClassPathXmlApplicationContext("app.xml");
        HotelDAO hdao=(HotelDAO)app.getBean("dao");
        List<HotelVO> list=hdao.hotelListData();
        for(HotelVO vo:list)
        {
        	System.out.println(vo.getName()+"("+vo.getScore()+")");
        }
        System.out.println("======= 상세보기 ========");
        HotelVO vo=hdao.hotelDetailData(1);
        System.out.println("번호:"+vo.getNo());
        System.out.println("호텔명:"+vo.getName());
        System.out.println("평점:"+vo.getScore());
        System.out.println("주소:"+vo.getAddress());
        
        Scanner scan=new Scanner(System.in);
        System.out.print("호텔명:");
        String name=scan.next();
        List<HotelVO> hList=hdao.hotelFindData(name);
        for(HotelVO hvo:hList)
        {
        	System.out.println(hvo.getName()+"("+hvo.getScore()+")");
        }
        System.out.println("========= 페이지 나누기 ==========");
        int curpage=1;
        int totalpage=hdao.hotelTotalPage();
        System.out.println("현재페이지:"+curpage);
        System.out.println("총페이지:"+totalpage);
        System.out.print("페이지 입력:");
        curpage=scan.nextInt();
        hList.clear();// 저장된 데이터 지워서 사용 
        hList=hdao.hotelPageingData(curpage);
        for(HotelVO hvo:hList)
        {
        	System.out.println(hvo.getName()+"("+hvo.getScore()+")");
        }
        
	}

}
