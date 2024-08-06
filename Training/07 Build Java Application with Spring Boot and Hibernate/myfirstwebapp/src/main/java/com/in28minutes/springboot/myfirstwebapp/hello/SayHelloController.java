package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloController {

	@RequestMapping("sayHello")
	@ResponseBody
	public String sayHello() {
		return "Hello, What are you learning today!";
	}

	@RequestMapping("sayHello-html")
	@ResponseBody
	public String sayHelloHtml() {
		StringBuffer sb = new StringBuffer();
		sb.append("<!DOCTYPE html>");
		sb.append("<html lang = 'en'>");
		sb.append("<head>");
		sb.append("<title>MY FIRST WEB PAGE IN SB</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<h1>My FIRST WEBPAGE in SPRING BOOT</h1>");
		sb.append("</body>");
		sb.append("</html>");
		
		return sb.toString();
	}
	
	@RequestMapping("sayHello-jsp")
	public String sayHelloJsp() {
		return "sayHello";
	}
}
