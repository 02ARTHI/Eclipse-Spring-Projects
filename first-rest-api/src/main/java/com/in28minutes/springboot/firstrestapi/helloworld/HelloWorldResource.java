package com.in28minutes.springboot.firstrestapi.helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
@RestController
public class HelloWorldResource {
 
	@RequestMapping("/hello")
	public String hello()
	{
		System.out.println("Hello world");
		return "hello world";
	}
	
	@RequestMapping("/hello-world-bean")
	public HelloWorldBean helloBean()
	{
		System.out.println("Hello world bean");
		return new HelloWorldBean("hello world");
	}
	
	@RequestMapping("/hello-world-path/{name}")
	public HelloWorldBean hellopath(@PathVariable String name)
	{
		System.out.println("Hello world" + name);
		return new HelloWorldBean("hello world, "+ name);
	}
	
	@RequestMapping(value={"/hello-world-path/{name}/{message}"})
	public HelloWorldBean hellopathsecond(@PathVariable String name, @PathVariable String message)
	{
		System.out.println("Hello world, " + name +"-"+ message);
		return new HelloWorldBean("hello world, "+ name +" -"+ message);
	}
	
	
}
