package com.xiaozai.business.web.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.FlashMap;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.xiaozai.business.domain.User;
import com.xiaozai.business.facade.ITestFacade;
import com.xiaozai.business.facade.IUserFacade;

@Controller
public class UserController {

	@Autowired
	private IUserFacade userFaced;
	
	@Autowired
	private ITestFacade testFacade;
	
	@RequestMapping(value="/test")
	@ResponseBody
	public String test(HttpServletRequest request, RedirectAttributes attr){
		String test = testFacade.test();
		request.setAttribute("requestAtrr", "rat");
		attr.addAttribute("redirectattr", "value1");
		attr.addFlashAttribute("dd", "ss");
//		flashMap.addTargetRequestParam("target", "tv");
		return test;
	}
	
	
	@RequestMapping(value="/hello")
	@ResponseBody
	public String hello(String name, HttpServletRequest request){
		String header = request.getHeader("content-type");
		String hello = userFaced.hello(name);
		return hello;
	}
	
	@RequestMapping("/user")
	@ResponseBody
	public User userByLoginName(String loginName){
		User userInfo = userFaced.userInfo(loginName);
		if(userInfo != null){
			System.out.println(userInfo.getId());
		}
		return userInfo;
	}
}
