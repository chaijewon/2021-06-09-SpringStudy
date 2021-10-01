package com.sist.dao;
import java.util.*;
import java.sql.*;
public class EmpDAO {
   private Connection conn; // 연결 
   private PreparedStatement ps; // SQL문장을 전송 
   // ======================= conn/ps => SqlSessionFactory(MyBatis)
   private String url,username,password;// 스프링을 통해서 주입 
   // 생성자 , setter사용 
   /*
    *    스프링에서 클래스 관리 
    *    1. 관리 대상의 클래스를 스프링에 전송 : app.xml 
    *       <bean>
    *       <context:component-scan base-package="">
    *       기능 (여러개의 클래스에서 사용, 메소드 여러군데에서 사용)
    *       === 기능을 가지고 있는 클래스 (컴포넌트)
    *       자바에서 사용하는 클래스 
    *         = 기능 (데이터베이스 : 추가,삭제,수정,상세보기...) 관리대상 
    *           => ~DAO, ~Manager(파일입출력,Jsoup파싱)
    *              ~Service(DAO 여러개를 한번에 묶어서 사용)
    *               =======
    *               BoardDAO , ReplyDAO(영화,뮤직,맛집) 
    *               =================== BoardService (BI)
    *         = 일반 데이터형으로 사용(int,double...) : 스프링의 관리 대상이 아니다
    *           ~VO(데이터베이스 연결 , 읽기/쓰기) , ~DTO(데이터를 모아서 웹에 전송) 
    *     2. 스프링 동작
    *        ApplicationContext app=
    *            new ClassPathXmlApplicationContext("app.xml");
    *        => 시작 
    *        1) app.xml을 읽어온다 
    *        2) xml 파싱을 시작한다 
    *           =======
    *            = JAXP (직접 파싱)
    *              = XML의 주요 사용처 
    *                = 설정파일 (메타파일)
    *                = 외부에 데이터를 전송 (XML:장점=호환성(모든 운영체제에서 
    *                                  동일한 번역)
    *                  웹 서버  ==> 브라우저
    *                        ==> 스마트 폰
    *                        ==> JavaScript => JSON번역(자바스크립트의 객체표현법) 
    *                            => 자바 JSON제작 
    *                               simple-json : VueJS,ReactVS,코틀린
    *                  ==> XML단점 : 파일크기 크기 (속도가 느려진다) ==> JSON
    *                      ======= 분산 (emp-mapper.xml,dept-mapper.xml)
    *                      ======= application-context.xml
    *                              application-datasoure.xml
    *                              두개이상의 설정 파일 => 동시에 읽기 
    *                              String[] s={"",""}
    *                              new ClassPathXmlApplicationContext(s)
    *                        new ClassPathXmlApplicationContext("application-*.xml")
    *              = DOM => 메모리에 트리형태로 저장해서 사용 
    *                    => 단점 : 속도가 느리다 
    *                    => 장점 : 메모리에 저장이 된상태 (수정,추가,삭제)
    *                    => 데이터베이스가 없는 경우 (데이터베이스)
    *              = SAX => 읽기전용 (Mybatis,Spring) => 오류나면 종료 
    *                       = 태그와 태그사이에 값을 읽는다 
    *                         <name>홍길동</name>
    *                               =====
    *                       = 태그의 속성값을 읽어 온다 
    *                         <a href="aaa">
    *                                  ====
    *                       = 장점 : XML을 데이터만 추출 속도가 빠르다 
    *                              메모리 누수현상이 없다 
    *                       = 단점 : 에러잡기가 어렵다 
    *               = 라이브러리 (스프링 방법 , 마이바티스 방식을 그대로 사용)
    *                          ============================ 표준화 
    *                 스프링 태그 / 마이바티스 태그 => 모든 개발자가 동일한 태그,속성을 사용
    *                 ======================
    *                 문제점 (태그?,속성?) => 스키마(스프링)(DTD보완) , DTD(마이바티스)
    *                       ? | * + default
    *            = JAXB (클래스 객체와 태그를 연결) => bind(1.8까지만 사용이 가능)
    *            
    *          = id와 class값을 읽어서 메모리 할당 Map에 저장 
    *            <bean id="a" class="A"/>
    *                         map.put("a",new A()) => Class.forName()
    *            => 생성자 DI가 먼저 수행 
    *          = setter DI실행 
    *          = method DI실행 
    *          =============================== 일단 종료 
    *          프로그래머 제작 (원하는 위치에 클래스주소를 얻어서 작업)
    *            = 클래스 객체를 얻어서 사용 
    *              = 프로그램을 이용해서 직접 가지고 온다
    *                getBean()
    *              = 스프링에 요청 (자동처리)
    *                @Autowired
    *              = 스프링에서 메모리 할당 
    *                각 클래스별로 등록
    *                패키지 단위 등록 <component-scan base-package="">
    *                
    *                com.sist.dao
    *                ADAO
    *                BDAO CDAO DDAO EDAO KDAO MDAO
    *                <bean id="a" class="ADAO">
    *                <bean id="b" class="BDAO">
    *                <bean id="c" class="CDAO">
    *                <bean id="d" class="DDAO">
    *                <bean id="e" class="EDAO">
    *                <bean id="k" class="KDAO">
    *                <bean id="M" class="MDAO">
    *                
    *                <context:component-scan base-package="com.sist.*">
    *          =============================== 소멸
    *          => 스프링은 클래스 객체/소멸만 담당(객체 생명주기)
    */
    // 드라이버 등록 
    public EmpDAO(String driverName)
    {
	   try
	   {
		   Class.forName(driverName);
	   }catch(Exception ex){}
    }
    
	public void setUrl(String url) {
		this.url = url;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public void setPassword(String password) {
		this.password = password;
	}
	// 오라클 연결 
	public void getConnection()
	{
		try
		{
			conn=DriverManager.getConnection(url,username,password);
		}catch(Exception ex){}
	}
	// 오라클 해제 
	public void disConnection()
	{
		try
		{
			if(ps!=null) ps.close();
			if(conn!=null) conn.close();
		}catch(Exception ex){}
	}
    // 1. 전체 목록 
	public List<EmpVO> empListData()
	{
		List<EmpVO> list=new ArrayList<EmpVO>();
		try
		{
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal "
					  +"FROM emp";
			ps=conn.prepareStatement(sql);
			// 실행후에 결과값을 달라
			ResultSet rs=ps.executeQuery();
			// => resultType="EmpVO"
			while(rs.next())
			{
				EmpVO vo=new EmpVO();
				vo.setEmpno(rs.getInt(1));
				vo.setEname(rs.getString(2));
				vo.setJob(rs.getString(3));
				vo.setHiredate(rs.getDate(4));
				vo.setSal(rs.getInt(5));
				list.add(vo); 
			}
			// selectList()
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return list;
	}
	// 2. 사번 => 상세보기 ==> paramterType="int" resultType="EmpVO"
	public EmpVO empDetailData(int empno)
	{
		EmpVO vo=new EmpVO();
		try
		{
			getConnection();
			String sql="SELECT empno,ename,job,hiredate,sal "
					  +"FROM emp "
					  +"WHERE empno=?"; //#{empno}
			ps=conn.prepareStatement(sql);
			ps.setInt(1, empno);
			ResultSet rs=ps.executeQuery();
			rs.next();
			vo.setEmpno(rs.getInt(1));
			vo.setEname(rs.getString(2));
			vo.setJob(rs.getString(3));
			vo.setHiredate(rs.getDate(4));
			vo.setSal(rs.getInt(5));
			rs.close();
		}catch(Exception ex)
		{
			ex.printStackTrace();
		}
		finally
		{
			disConnection();
		}
		return vo;
	}
}






