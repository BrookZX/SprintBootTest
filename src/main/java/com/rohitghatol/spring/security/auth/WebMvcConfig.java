package com.rohitghatol.spring.security.auth;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer; 

@Configuration 
public class WebMvcConfig implements WebMvcConfigurer  {

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		// TODO Auto-generated method stub
//		WebMvcConfigurer.super.addViewControllers(registry);
		System.out.println("MVC loaded @@@@@@@@@@@@@");
		  registry.addViewController("/loginpage").setViewName("login"); 
	}
	
}
