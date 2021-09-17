package com.sist.movie;
import java.util.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
public class MainModel {
   @RequestMapping("main/main.do")
   public String main_main(HttpServletRequest request,HttpServletResponse response)
   {
	   List<String> list=new ArrayList<String>();
	   list.add("홍길동");
	   list.add("심청이");
	   list.add("박문수");
	   request.setAttribute("list", list);
	   return "main/main"; // return "redirect:../main/main.do"
   }
}
