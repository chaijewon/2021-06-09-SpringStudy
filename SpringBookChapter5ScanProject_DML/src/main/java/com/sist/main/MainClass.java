package com.sist.main;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;

// 메모리 할당 요청 

@Component
public class MainClass {
    // 프로그램에서 필요한 객체를 스프링으로부터 받아온다
	@Autowired
	private StudentDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // 스프링 => 클래스 관리 요청 
		ApplicationContext app=
			new ClassPathXmlApplicationContext("app.xml");
		MainClass mc=(MainClass)app.getBean("mainClass");
		while(true)
		{
			System.out.println("====== 메뉴 ======");
			System.out.println("1.학생 목록");
			System.out.println("2.학생 추가");
			System.out.println("3.학생 상세보기");
			System.out.println("4.학생 수정");
			System.out.println("5.학생 삭제");
			System.out.println("6.학생 찾기");
			System.out.println("7.프로그램 종료");
			System.out.println("=================");
			Scanner scan=new Scanner(System.in);
			System.out.print("메뉴 선택:");
			int menu=scan.nextInt();
			switch(menu)
			{
			case 1: mc.studentListData(); break;
			case 2: mc.studentInsert(); break;
			case 3: mc.studentDetailData(); break;
			case 7: System.out.println("프로그램을 종료합니다!!");
				    System.exit(0);break;
			case 4: mc.studentUpdate();break;
			case 5: mc.studentDelete();break;
			case 6: mc.studentFind();break;
			}
		}
	}
    public void studentInsert()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("이름:");
    	String name=scan.next();
    	System.out.print("국어점수:");
    	int kor=scan.nextInt();
    	System.out.print("영어점수:");
    	int eng=scan.nextInt();
    	System.out.print("수학점수:");
    	int math=scan.nextInt();
    	
    	StudentVO vo=new StudentVO();
    	vo.setName(name);
    	vo.setKor(kor);
    	vo.setEng(eng);
    	vo.setMath(math);
    	
    	dao.studentInsert(vo);
    }
    public void studentListData()
    {
    	List<StudentVO> list=dao.studentListData();
    	System.out.println("===== 학생목록 =====");
    	for(StudentVO vo:list)
    	{
    		System.out.println(vo.getHakbun()+" "
    				+vo.getName()+" "
    				+vo.getKor()+" "
    				+vo.getEng()+" "
    				+vo.getMath());
    	}
    }
    public void studentDetailData()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("학번 입력:");
    	int hakbun=scan.nextInt();
    	StudentVO vo=dao.studentDetailData(hakbun);
    	System.out.println("===== 상세보기 =====");
    	System.out.println("학번:"+vo.getHakbun());
    	System.out.println("이름:"+vo.getName());
    	System.out.println("국어점수:"+vo.getKor());
    	System.out.println("영어점수:"+vo.getEng());
    	System.out.println("수학점수:"+vo.getMath());
    	System.out.println("총점:"+vo.getTotal());
    	System.out.printf("평균:%.2f\n",vo.getAvg());
    	System.out.println("등수:"+vo.getRank());
    	System.out.println("=================");
    }
    public void studentUpdate()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("이름:");
    	String name=scan.next();
    	System.out.print("국어점수:");
    	int kor=scan.nextInt();
    	System.out.print("영어점수:");
    	int eng=scan.nextInt();
    	System.out.print("수학점수:");
    	int math=scan.nextInt();
    	System.out.println("변경할 학번:");
    	int hakbun=scan.nextInt();
    	
    	StudentVO vo=new StudentVO();
    	vo.setName(name);
    	vo.setKor(kor);
    	vo.setEng(eng);
    	vo.setMath(math);
    	vo.setHakbun(hakbun);
    	
    	dao.studentUpdate(vo);
    	System.out.println("수정되었습니다!!");
    }
    public void studentDelete()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("삭제할 학번 입력:");
    	int hakbun=scan.nextInt();
    	dao.studentDelete(hakbun);
    	System.out.println("삭제되었습니다!!");
    }
    public void studentFind()
    {
    	Scanner scan=new Scanner(System.in);
    	System.out.print("검색어 입력:");
    	String name=scan.next();
    	List<StudentVO> list=dao.studentFindData(name);
    	for(StudentVO vo:list)
    	{
    		System.out.println(vo.getHakbun()+" "
    				+vo.getName()+" "
    				+vo.getKor()+" "
    				+vo.getEng()+" "
    				+vo.getMath());
    	}
    	
    }
}
