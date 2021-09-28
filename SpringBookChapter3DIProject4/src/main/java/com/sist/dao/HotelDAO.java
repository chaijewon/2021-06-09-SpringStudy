package com.sist.dao;
import java.util.*;
import java.sql.*;
/*
 *   public class A
 *   {
 *      public A()
 *      {
 *      }
 *      public void setData(String data)
 *      {
 *      }
 *   }
 *   
 *    A a=new A(); // 메모리 저장 
 *    => Class cls=Class.forName() 
 *    => Object obj=cls.newInstance() ==> A() 생성자 호출 
 *    a.setData("aaa")
 *    
 *    A a;
 *    a.setData();
 *    a=new A();
 *   
 */
// => 스프링 순서 (메모리 할당(생성자 호출) => setter DI , method DI(init-method,destory-method))
// 소스의 간결화 , 결합성이 낮은 프로그램 
// 공통모듈 => 필요시마다 호출이 가능하게 만든다 (AOP,인터셉트)
// 유연성 => 전체 내용을 변경이 가능하다 
public class HotelDAO {
    private Connection conn;
    private PreparedStatement ps;
    private SeoulDataSource ds;
    // 스프링에서 데이터값을 받는다 
	public void setDs(SeoulDataSource ds) {
		this.ds = ds;
	}
	// dirver 등록 : => 생성자 , setter가 다음에 실행된다 
	public HotelDAO(String driverName)
	{
		try
		{
			Class.forName(driverName);
		}catch(Exception ex){}
	}
	// 같은 기능을 가지고 있는 메소드를 모아서 처리 (공통모듈)
    public void getConnection()
    {
    	try
    	{
    		conn=DriverManager.getConnection(ds.getUrl(),
    				ds.getUsername(),ds.getPassword());
    	}catch(Exception ex){}
    }
    public void disConnection()
    {
    	try
    	{
    		if(ps!=null) ps.close();
    		if(conn!=null) conn.close();
    	}catch(Exception ex){}
    }
    public List<HotelVO> hotelFindData(String addr)
    {
    	List<HotelVO> list=new ArrayList<HotelVO>();
    	try
    	{
    		getConnection();
    		String sql="SELECT name,score FROM seoul_hotel "
    				  +"WHERE address LIKE '%'||?||'%'";
    		ps=conn.prepareStatement(sql);
    		ps.setString(1, addr);
    		ResultSet rs=ps.executeQuery();
    		while(rs.next())
    		{
    			HotelVO vo=new HotelVO();
    			vo.setName(rs.getString(1));
    			vo.setScore(rs.getDouble(2));
    			list.add(vo);
    		}
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
}
