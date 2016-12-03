package com.xiaozai.business.web.controller;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiaozai.business.facade.IUserFacade;

public class TestCosummer {

	 public static void main(String[] args) {  
	        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("config/spring-context-consumer.xml");  
	        context.start();  
	        IUserFacade demoService = (IUserFacade)context.getBean("userFaced"); // 获取远程服务代理  
	        String hello = demoService.hello("world"); // 执行远程方法  
	        System.out.println(hello);  
	    } 
}
