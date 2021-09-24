package com.sist.userdi;
import java.io.File;
import java.util.*;

import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
public class ClassPathXmlApplicationContext implements ApplicationContext{
    private Map clsMap=new HashMap();
	public ClassPathXmlApplicationContext(String path) {
		// TODO Auto-generated constructor stub
		try
		{
			SAXParserFactory spf=SAXParserFactory.newInstance();
			SAXParser sp=spf.newSAXParser();
			XMLParser xp=new XMLParser();
			sp.parse(new File(path), xp);
			clsMap=xp.map;
		}catch(Exception ex){}
	}
	// 저장된 클래스를 찾는 경우에 사용 
	@Override
	public Object getBean(String key) {
		// TODO Auto-generated method stub
		return clsMap.get(key);
	}

}
