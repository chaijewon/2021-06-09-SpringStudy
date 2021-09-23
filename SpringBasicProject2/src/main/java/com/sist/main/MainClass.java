package com.sist.main;
import java.util.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\springDev2\\springStudy\\SpringBasicProject2\\src\\main\\java\\com\\sist\\main\\app.xml";
	    ApplicationContext app=
	    		new ClassPathXMLApplicationContext(path);
	    MovieDAO dao=(MovieDAO)app.getBean("dao");
	    System.out.println("dao:"+dao);
	    /*MovieDAO dao2=(MovieDAO)app.getBean("dao");
	    System.out.println("dao2:"+dao2);*/
	    List<MovieVO> list=dao.movieListData();
	    for(MovieVO vo:list)
	    {
	    	System.out.println("영화번호:"+vo.getMno());
	    	System.out.println("영화명:"+vo.getTitle());
	    	System.out.println("감독:"+vo.getDirector());
	    	System.out.println("출연:"+vo.getActor());
	    	System.out.println("장르:"+vo.getGenre());
	    	System.out.println("====================================");
	    }
	}

}
