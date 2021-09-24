package com.sist.userdi;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.lang.reflect.Method;
import java.util.*;
// 스프링에서 사용하는 파싱 (SAX) => readonly
// 솔루션 => Daum/Naver => DispatcherServlet(XML,Annotation)
// app.xml 만든지 (사이버다임) = 설계(아키텍스) => 6개월 (대기업)
// 미국 : 아키텍처 , 구현 : 인도
/*
 *   <?xml version="1.0" encoding="UTF-8"?> => startDocument()
		<beans> => startElement()
		  <bean id="std" class="com.sist.userdi.Student"> => startElement()
		    <property name="hakbun" value="1"/>
		    startElement()              endElement()
		    <property name="name" value="홍길동"/>
		    startElement()              endElement()
		    <property name="sex" value="남자"/>
		    startElement()              endElement()
		  </bean> => endElement()
		</beans>  => endElement()
		=> endDocument()
 */
public class XMLParser extends DefaultHandler{
    Map map=new HashMap();
    Class clsName;
    Object obj;
	@Override
	public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
		try
		{
			if(qName.equals("bean"))
			{
				String id=attributes.getValue("id");
				String cls=attributes.getValue("class");
				clsName=Class.forName(cls);
				obj=clsName.getDeclaredConstructor().newInstance();
				map.put(id, obj);
			}
			if(qName.equals("property"))
			{
				String name=attributes.getValue("name");
				String value=attributes.getValue("value");
				Method[] methods=clsName.getDeclaredMethods();
				for(Method m:methods)
				{
					if(m.getName().equalsIgnoreCase("set"+name))
					{
						m.invoke(obj, value);
					}
				}
				
			}
		}catch(Exception ex){}
	}
   
}




