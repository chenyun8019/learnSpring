package com.jj.learnSpring;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SpringController {
	@RequestMapping(value="/cy",method=RequestMethod.GET)
	public String show(){
		return "这是我自己第一次写的SpringBoot";
	}

}
