package com.sist.main;
import java.util.*;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.sist.config.FoodConfig;
import com.sist.dao.*;

public class MainClass2 {
	
    private FoodDAO dao; // new를 사용하면 => new FoodDAO();
    // url,username,password,driverName=> 설정되지 않는다 (설정된 곳:스프링에 등록된 클래스)
    public void setDao(FoodDAO dao) {
		this.dao = dao;
	}
    /*
     *   *** XML은 id가 자동생성되지 않는다 
     *   <bean id="" class=""> (O)
     *   <bean class=""> (X)
     *   *** Annotation을 이용할때만 자동 생성된다 
     *   @Bean("") => (O)
     *   @Bean => 디폴트 ID를 설정한다 (클래스명의 글자수 작은 경우)
     *   SpringFrameWork =>springFrameWork
     *   @Bean("sfw")
     */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        	new AnnotationConfigApplicationContext(FoodConfig.class);
        // MainClass를 가지고 온다 (스프링에 셋팅된 MainClass만 FoodDAO를 가지고 있다)
        MainClass2 mc=(MainClass2)app.getBean("mc");
       
        MainClass2 mc1=(MainClass2)app.getBean("mc");
        System.out.println(mc+"|"+mc1);
        // 단일 객체 : getBean("mc") => 소프트웨어 (싱글턴) => 같은 객체를 이용하면 
        List<FoodVO> list=mc.dao.foodListData();
        for(FoodVO vo:list)
        {
        	System.out.println(vo.getName());
        }
	}

	

}
