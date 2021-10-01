package com.sist.main;
// JSP => 조립기
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sist.dao.*;
@Component
public class MainClass {
	@Autowired
    private EmpJoinDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        // XML => 동작 요청
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
	}

}



