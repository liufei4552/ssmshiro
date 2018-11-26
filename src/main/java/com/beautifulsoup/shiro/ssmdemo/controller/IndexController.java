package com.beautifulsoup.shiro.ssmdemo.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class IndexController {
		
	@RequestMapping("/index")
	public String index(){
		return "index";
	}
	
	@RequestMapping("/login")
	public String login(HttpServletRequest request) throws Exception{
		String exceptionClassName = (String) request.getAttribute("shiroLoginFailure");
		//根据shiro返回的异常类路径判断，抛出指定异常信息
		if(exceptionClassName!=null){
			if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
				//最终会抛给异常处理器
				throw new UnknownAccountException("账号不存在");
			} else if (IncorrectCredentialsException.class.getName().equals(exceptionClassName)) {
				throw new IncorrectCredentialsException("用户名/密码错误");
			}else {
				throw new Exception();//最终在异常处理器生成未知错误
			}
		}
		return "login";
	}
	
	@RequestMapping("/refuse")
	public String refuse(){
		return "refuse";
	}
}
