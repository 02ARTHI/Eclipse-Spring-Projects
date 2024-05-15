package com.in28minutes.rest.webservices.restfulwebservices.helloworld;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {
  
	@GetMapping("/hello")
	//@RequestMapping(method= RequestMethod.GET, path="/hello-world")
	@ResponseBody
	public String hello()
	{
		return "hello world";
	}
	
	@GetMapping("/hello-bean")
	public HelloWorldBean hellobean()
	{ 
		return new HelloWorldBean("hi");
	}
	
	@GetMapping("/hello/{name}")
	public HelloWorldBean hellobeanpath(@PathVariable String name)
	{ 
		return new HelloWorldBean("hi  "+name);
	}
}
