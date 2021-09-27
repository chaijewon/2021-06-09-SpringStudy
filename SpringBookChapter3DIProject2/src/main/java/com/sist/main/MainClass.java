package com.sist.main;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sist.dao.*;
// com.sist.dao.MusicDAO dao
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML을 스프링에 전송 => XML파싱후에 => 객체를 생성 => DI(생성자,setter) => 
		// map에 저장 ==> 필요한 위치에서 저장된 객체를 사용한다 (getBean()) => DL
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		// 사용자에게 뮤직정보를 보여준다 (스프링에 저장된 DAO가 필요)
		MusicDAO dao=(MusicDAO)app.getBean("dao");
		List<MusicVO> list=dao.musicListData();
		for(MusicVO vo:list)
		{
			System.out.println(vo.getNo()+"."+vo.getTitle()+"("+vo.getSinger()+")");
		}
	}

}
