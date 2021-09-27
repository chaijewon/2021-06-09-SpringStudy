package com.sist.main;
import com.sist.dao.*;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

//import com.sist.config.*;
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        	new AnnotationConfigApplicationContext(com.sist.config.MusicConfig.class);
        MusicDAO dao=(MusicDAO)app.getBean("dao");
        List<MusicVO> list=dao.musicListData();
        for(MusicVO vo:list)
        {
        	System.out.println("순위:"+vo.getNo());
        	System.out.println("제목:"+vo.getTitle());
        	System.out.println("가수:"+vo.getSinger());
        	System.out.println("=======================================");
        }
	}

}
