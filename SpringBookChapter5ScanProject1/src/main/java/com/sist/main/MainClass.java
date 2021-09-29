package com.sist.main;

// 일반 XML (클래스마다 등록)
// Component-Scan (패키지 단위)
// XML + Annotation (핵심)
/*
 *   메모리할당 
 *    = 라이브러리 메모리 할당 (MyBatis) SqlSessionFactory => XML
 *    = 사용자 정의는 어노테이션을 이용해서 메모리 할당 
 */
/*
 *   => 단점 : 선택 (어노테이션)
 *   메모리 할당하는 어노테이션 (137page)
 *     = Component : 일반 클래스 (~Manager,MainClass)
 *     = Service : DAO+DAO (BI) 
 *     = Repository : 저장소 (~DAO)
 *     = Controller : Model(MVC) ==> MainModel
 *     = RestController : Rest서비스 (JSON전송)
 *   주입하는 어노테이션 (DI)
 *     = Autowired : 자동 주입 
 *     = Inject
 *     = PostConstructor : init-method
 *     = PreDestroy : destory-method
 */
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
public class MainClass {
	@Autowired
    private GenieDAO gdao;
	
	@Autowired
	private MelonDAO mdao;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // xml을 컨테이너에 전송 
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		//MainClass mc=(MainClass)app.getBean("mc");
		// Object가 가장 큰 클래스 => 형변환 (자바의 정석 => 상속) 
		MainClass mc=app.getBean("mc",MainClass.class);//제네릭스
		// 데이터를 읽어 온다
		List<GenieVO> list=mc.gdao.genieListData();
		// 출력 
		for(GenieVO vo:list)
		{
			System.out.println(vo.getGenie_no()+"."
		         +vo.getGenie_title());
		}
		System.out.println("=================================");
		list=mc.gdao.genieListData2();
		for(GenieVO vo:list)
		{
			System.out.println(vo.getGenie_no()+"."
		         +vo.getGenie_title()+"("+vo.getGenie_singer()+")");
		}
		// int a=(int)2.4;
		System.out.println("=======Melon 출력========");
		List<MelonVO> mList=mc.mdao.melonListData();
		for(MelonVO vo:mList)
		{
		    System.out.println(vo.getNo()+"."
		      +vo.getTitle()+"("+vo.getAlbum()+")");
		}
	}

}





