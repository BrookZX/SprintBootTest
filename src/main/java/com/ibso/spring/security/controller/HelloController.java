package com.ibso.spring.security.controller;
 
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
 
@Controller
public class HelloController {
	
	@PreAuthorize("permitAll()")
	@RequestMapping(value={"/welcome","/"},method=RequestMethod.GET)
	public String welcome(){

		System.out.println("hello index");
		return "index";
	}
}
