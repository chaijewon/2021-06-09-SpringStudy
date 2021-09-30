package com.sist.main;
import java.util.*;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.config.HotelConfig;
import com.sist.dao.*;
// 스프링에서 메모리 할당 => @Autowired(사용)
/*
 *   클래스를 관리 => 컨테이너 클래스 
 *   AnnotationConfigApplicationContext : 자바로 설정 
 *   ApplicationContext : XML로 설정
 *    => GenericApplicationContext => 소멸
 */
// 자동 ID사용 => id부여하지 않은 경우 (클래스명 => 클래스명의 첫자만 소문자)
// MainClass => mainClass , HotelDAO => hotelDAO (139page)
/*
 *     1. 메모리 할당과 관련된 어노테이션 
 *        @Component , @Repository , @Service , @Controller, @RestController
 *     2. 주입 (DI)와 관련된 어노테이션 
 *        @Autowired , @Resource ==> 객체주소값을 스프링을 통해서 주입을 받는 경우
 *        @PostConstruct ,@PreDestroy  => 메소드 DI
 *     => 패키지단위 등록 : Component-Scan
 */
@Component
public class MainClass {
	@Autowired
    private HotelDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 스프링 => 메모리할당과 DI 요청 
		AnnotationConfigApplicationContext app=
			new AnnotationConfigApplicationContext(HotelConfig.class);
	    //@Autowired => 스프링에서 메모리를 할당해서 저장된 클래스를 가지고 온다
		MainClass mc=(MainClass)app.getBean("mainClass");
		//MainClass mc=app.getBean("mainClass",MainClass.class);
		List<HotelVO> list=mc.dao.hotelListData();
		//mc.init(); => 자동화처리 
		for(HotelVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getName()+"("+vo.getScore()+")");
			System.out.println(vo.getAddress());
			System.out.println("===========================================");
		}
		System.out.println("===========상세보기==============");
		Scanner scan=new Scanner(System.in);
		System.out.print("1~387번 선택:");
		int no=scan.nextInt();
		HotelVO vo=mc.dao.hotelDetailData(no);
		System.out.println("번호:"+vo.getNo());
		System.out.println("호텔명:"+vo.getName());
		System.out.println("평점:"+vo.getScore());
		System.out.println("주소:"+vo.getAddress());
		app.close();
	}
	// 메소드 DI => 시작과 동시에 호출 요청 (init-method) 11(javax.annotation)
	// => 추천 , 챗봇 ==> 트위터(시작가 동시에 트워터 읽어라)
	// 챗봇 => 카카오 (라이브러리) => X
	// 결재 ==> 
	@PostConstruct
	public void init()
	{
		System.out.println("===== 서울지역 호텔 목록 =====");
	}
	// 프로그램 종료 (등록된 모든 클래스 메모리 해제 => destory-method)
	// 컨테이너를 종료시에 호출 
	@PreDestroy  
	public void destory()
	{
		System.out.println("#####스프링에서 모든 객체 메모리 해제 #####");
	}

}





