package com.sist.main;
// 프로그램 조립기 (스프링을 연결하는 소스) => 66page
/*
 *    스프링 
 *      = 컨테이너 (필요한 컴포넌트를 모아서 관리) => 사용자 정의가 아니다
 *        ================================ 라이브러리 
 *              ==> 컴포넌트 등록 (XML,Annotation)
 *      = 컴포넌트 (기능을 가지고 있는 클래스 : DAO,Manager,Model...)
 *              ==> 이전의 자바프로그램과 동일 
 *      = 조립 (main())
 */
/*
 *   =============================
 *   1. Application : main() 있는 클래스 
 *   2. Web Application : Model클래스에서 조립 
 *   ============================= 스프링 
 *   3. Mobile Application(코틀린) => Activity(액정화면) : 클라이언트
 *      ========================= 오라클 연결 (X) => 스프링 서버에서 결과값
 *      => 웹/앱 (단점 : 안드로이드에서만 사용이 가능) 
 *      => React-Native (안드로이드/아이폰 통합)  => 5G
 *      
 */
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
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
        // 조립 => 등록된 클래스를 읽어간다
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// 클래스 메모리 할당 => setter DI
		MainClass mc=(MainClass)app.getBean("mc");
		
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
