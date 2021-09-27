package com.sist.main;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
/*
 *    스프링 : 객체생성 , 객체 찾아서 사용이 가능하게 만들어 준다 (DL)
 *                   => getBean(id명)
 *           생성 / 소멸에 신경쓰지 않고 핵심맘 코딩이 가능하게 만들어 준다 
 */
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String[] xml={"sawon.xml","member.xml"};
        ApplicationContext app=
        		new ClassPathXmlApplicationContext(xml);
        Sawon s=(Sawon)app.getBean("sa");
        System.out.println("s="+s);
        s.setName("홍길동");
        s.setDept("개발부");
        s.setJob("대리");
        s.setLoc("서울");
        s.setPay(4200);
        
        System.out.println("이름:"+s.getName());
        System.out.println("직위:"+s.getJob());
        System.out.println("부서:"+s.getDept());
        System.out.println("근무지:"+s.getLoc());
        System.out.println("연봉:"+s.getPay());
        
        Member m=(Member)app.getBean("mem");
        System.out.println("m="+m);
        m.setNo(1);
        m.setName("심청이");
        m.setSex("여자");
        m.setAddr("서울시 마포구");
        m.setTel("010-1111-1111");
        System.out.println("회원번호:"+m.getNo());
        System.out.println("이름:"+m.getName());
        System.out.println("성별:"+m.getSex());
        System.out.println("주소:"+m.getAddr());
        System.out.println("전화:"+m.getTel());
	}

}
