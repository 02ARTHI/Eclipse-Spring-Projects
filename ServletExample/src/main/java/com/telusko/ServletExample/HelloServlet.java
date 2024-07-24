package com.telusko.ServletExample;

import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

import javax.servlet.http.HttpServlet;

public class HelloServlet extends HttpServlet{
    
	 public void service (HttpRequest req, HttpResponse res)
	 {
		 System.out.println("in service");
	 }
}
