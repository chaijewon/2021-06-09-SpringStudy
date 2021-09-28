package com.sist.two;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
// 97page 
/*
 *   4 => XML
 *   5 => Annotation 
 *   스프링에 저장된 클래스를 찾을 경우 => getBean()
 *   
 *   Object getBean() 
 *   
 *   => A a=(A)app.getBean("id")
 *   => A a=app.getBean("id",A.class)
 *   
 *   101page 
 *   => 스프링에 저장되는 클래스 (빈)
 *      => 기능을 가지고 있다 (여러개의 클래스에서 사용할 수 있는 클래스)
 *         웹 : ~DAO ,  ~Model , ~Manager , ~Service(한개이상의 기능을 가지고 있다
 *                       => 컴포넌트)
 *         저장하지 않는 클래스 : ~VO(데아터형)
 *      => 모든 클래스를 등록하지 않는다 필요한 클래스만 저장한후 관리요청 
 *      
 *      설정 파일이 두개이상일 경우
 *      @Import({SawonConfig.class,MemberConfig.class})
 *      
 *      Class[] cls={SawonConfig.class,MemberConfig.class}
 *      AnnotationConfigApplicationContext app=
 *         new AnnotationConfigApplicationContext(cls)
 *         
 *      regex => app*.xml
 */
@Configuration
@Import({SawonConfig.class,MemberConfig.class})
public class MainConfig {
  
}
