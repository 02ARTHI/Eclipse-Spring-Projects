package com.in28minutes.springboot.myfirstwebapp.hello;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SayHelloContainer {
	
	@RequestMapping("say-hello")
	@ResponseBody
	public String sayHello()
	{
		return "hello, what ae you learning today?";
	}
	
	@RequestMapping("say-hello-html")
	@ResponseBody
	public String sayHelloHtml()
	{
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<title>my first html page</title>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("my first html body page");
		sb.append("</body>");
		sb.append("</html>");
		
		
		return sb.toString();
	}
	
	@RequestMapping("say-hello-jsp")
	public String sayHelloJsp()
	{
		return "sayHello";
	}
}
