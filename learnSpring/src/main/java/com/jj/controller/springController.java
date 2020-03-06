package com.jj.controller;

import java.util.Objects;

import javax.security.auth.message.callback.SecretKeyCallback.Request;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class springController {
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

}
