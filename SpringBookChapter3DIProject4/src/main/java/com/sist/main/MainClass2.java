package com.sist.main;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.MainConfig;
import com.sist.dao.*;
public class MainClass2 {
    private HotelDAO hdao;
    private NatureDAO ndao;
    private LocationDAO ldao;
    
	public void setHdao(HotelDAO hdao) {
		this.hdao = hdao;
	}

	public void setNdao(NatureDAO ndao) {
		this.ndao = ndao;
	}

	public void setLdao(LocationDAO ldao) {
		this.ldao = ldao;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Class[] cls={LocationConfig.class,MainConfig.class}
		// ApplicationContext ==> String[]
		// AnnotationConfigApplicationContext => Class[]
        AnnotationConfigApplicationContext app=
        	new AnnotationConfigApplicationContext(MainConfig.class);
     // 클래스 메모리 할당 => setter DI
     		MainClass2 mc=(MainClass2)app.getBean("mc");
     		
     		Scanner scan=new Scanner(System.in);
     		System.out.print("입력:");
     		String gu=scan.next();
     		
     		List<HotelVO> hList=mc.hdao.hotelFindData(gu);
     		List<NatureVO> nList=mc.ndao.natureFindData(gu);
     		List<LocationVO> lList=mc.ldao.locationFindData(gu);
     		
     		System.out.println("======= 호텔 목록 ========");
     		for(HotelVO vo:hList)
     		{
     			System.out.println(vo.getName()+"("+vo.getScore()+")");
     		}
     		
     		System.out.println("======= 명소 목록 =========");
     		for(LocationVO vo:lList)
     		{
     			System.out.println(vo.getTitle());
     		}
     		
     		System.out.println("======= 자연/관광 =========");
     		for(NatureVO vo:nList)
     		{
     			System.out.println(vo.getTitle());
     		}
	}

}
