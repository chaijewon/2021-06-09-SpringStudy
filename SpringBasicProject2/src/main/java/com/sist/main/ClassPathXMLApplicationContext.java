package com.sist.main;
import java.util.*;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.*;
import java.io.*;
public class ClassPathXMLApplicationContext implements ApplicationContext{
    private Map map=new HashMap();
	public ClassPathXMLApplicationContext(String path) {
		try
		{
			DocumentBuilderFactory dbf=DocumentBuilderFactory.newInstance();
			// 파싱기 => XML을 읽어서 데이터를 읽기어 온다 
			DocumentBuilder db=dbf.newDocumentBuilder();
			Document doc=db.parse(new File(path));
			// 루트 태그 읽기 (계층구조) // beans => bean 
			Element root=doc.getDocumentElement();
			System.out.println("root tag:"+root.getTagName());//beans
			// 등록된 클래스를 모아온다 
			NodeList list=root.getElementsByTagName("bean");
			for(int i=0;i<list.getLength();i++)
			{
				Element bean=(Element)list.item(i);
				String id=bean.getAttribute("id");
				String cls=bean.getAttribute("class");
				// <bean id="dao" class="com.sist.main.MovieDAO"/>
				Class clsName=Class.forName(cls);
				Object obj=clsName.getDeclaredConstructor().newInstance();
				map.put(id, obj);
			}
		}catch(Exception ex){}
	}
	@Override
	public Object getBean(String key) {
		// TODO Auto-generated method stub
		return map.get(key);
	}

}
