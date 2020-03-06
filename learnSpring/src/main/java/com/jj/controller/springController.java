package com.jj.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class springController<B, A> {
	@RequestMapping(value="/getwithoutpara",method=RequestMethod.GET)
	public String toGet(HttpServletResponse re){
//		HttpServletResponse re	
 		Cookie ck=new Cookie("login","ture");
 		re.addCookie(ck);
		return "this is a no para request";
		
	}
	@RequestMapping(value="/getwithoutpara1",method=RequestMethod.GET)
	public String tt(HttpServletRequest hr){
		Cookie [] cks=hr.getCookies();
		if(Objects.isNull(cks)){
			return "需要携带Cookie访问1";
		}
		for(Cookie co:cks){
			if(co.getName().equals("login") && co.getValue().equals("ture1")){
				return "this is a no para request2020-3-6";
			}
		}
		
		return "需要携带Cookie访问2";
		
	}
	
	
	@RequestMapping(value="/getwithpara1",method=RequestMethod.GET)
	public Map<String,String> getMap(@RequestParam Integer s,@RequestParam Integer e){
		
		Map<String,String> list=new HashMap();
		list.put("第一", "the first");
		list.put("第二", "the second");
		list.put("第三", "the third");
		
		return list;
	}
	
	@RequestMapping(value="/getwithpara",method=RequestMethod.GET)
	public Map<String,String> getMap1(@RequestParam Integer s,@RequestParam Integer e){
		
		Map<String,String> list=new HashMap();
		list.put("age", "12");
		list.put("ad", "hunan");
		
		return list;
	}
	
	
	@RequestMapping(value="/getwithpara11/{a}/{b}",method=RequestMethod.GET)
	public Map get(@PathVariable Integer a,@PathVariable Integer b){
		Map<String,String> li=new HashMap();
		li.put("one", "hello");
		li.put("two", "world");
		
		return li;		
	}
	

}
