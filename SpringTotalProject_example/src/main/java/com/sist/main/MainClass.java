package com.sist.main;
// JSP => 조립기
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
/*
 *    SQL 
 *    ====
 *      DML 
 *        = SELECT
 *            = 연산자 
 *            = 내장함수
 *            = JOIN : INNER JOIN / OUTER JOIN
 *            = SUBQUERY : 스칼라 서브쿼리 
 *        = INSERT
 *        = UPDATE
 *        = DELETE
 *      DDL
 *        = CREATE  => TABLE / SEQUENCE / VIEW / PL/SQL 
 *        = ALTER
 *           = ADD
 *           = MODIFY
 *           = DROP
 *        = DROP
 *        = TRUNCATE
 *        = RENAME 
 *      TCL
 *        = COMMIT
 *        = ROLLBACK 
 *    
 *    자바 
 *      = 변수 (지역변수 / 전역변수 (instance/static))
 *      = 연산자 , 제어문 
 *      = 배열 (1차원 배열) 
 *      = 클래스의 개념 => 데이터형 / 액션(기능)
 *        ==========
 *         구성요소 : 메소드 , 생성자 
 *      = 객체지향 프로그램 
 *        = 캡슐화 
 *        = 상속/포함 
 *        = 다형성(오버로딩 /오버라이딩)
 *      = 클래스 종류 
 *        = 추상 클래스 
 *        = 인터페이스 
 *      = 예외처리 
 *        = 예외복귀(try~catch)
 *        = 예외회피(throws)
 *      = 라이브러리 
 *        java.lang(Object,String,StringBuffer,Wrapper)
 *        java.util(StringTokenizer,Date,Calendar,Collection)
 *                 Colleaction:Map,ArrayList
 *        java.io : FileInputStream , FileOutputStream 
 *                  FileReader , FileWriter
 *        java.net : URL , URLEncoder
 *     ==================== 자바의 기술면접 ======================
 *           자바질문에 대답 못하면 입사불가능
 *           코딩테스트(백지) => Queue
 *           
 *     JSP  ==> 내장 객체 , JSTL, EL , MVC
 *     HTML/CSS => 태그 / 속성 
 *     JavaScript : AJAX , JQUERY , VUE , REACT , NODEJS
 */
@Component
public class MainClass {
	@Autowired
    private EmpJoinDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML => 동작 요청
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		List<EmpVO> list=mc.dao.empdeptJoinData();
		for(EmpVO vo:list)
		{
			System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" "
					+vo.getJob()+" "
					+vo.getDvo().getDname()+" "
					+vo.getDvo().getLoc());
		}
		/*
		 *  		System.out.println(vo.getEmpno()+" "
					+vo.getEname()+" " ${vo.ename}
					+vo.getJob()+" "
					+vo.getDvo().getDname()+" " ${vo.dvo.dname}
					+vo.getDvo().getLoc()); ${vo.dvo.loc}
					
					=> Vue ==> {{vo.loc}}
					=> React ==> {vo.loc}
					=> 장고 ==> {{vo.loc}}   [[]]
		 */
		System.out.println("========= 상세보기 =======");
		EmpVO vo=mc.dao.empdeptDetailData(7788);
		System.out.println(vo.getEmpno()+" "
				+vo.getEname()+" "
				+vo.getJob()+" "
				+vo.getDvo().getDname()+" "
				+vo.getDvo().getLoc());
	}

}



