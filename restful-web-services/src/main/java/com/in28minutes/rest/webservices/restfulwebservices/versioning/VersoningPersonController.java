package com.in28minutes.rest.webservices.restfulwebservices.versioning;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VersoningPersonController {
      
	@GetMapping("/v1/person")
	public PersonV1 getperson()
	{
		return new PersonV1("arthi selvaraj");
	}
	
	@GetMapping("/v2/person")
	public PersonV2 getpersonv2()
	{
		return new PersonV2(new Name("arthi"," selvaraj"));
	}
	
	@GetMapping(path= "/person", params="version=1")
	public PersonV1 getpersonRequestParamV1()
	{
		return new PersonV1("arthi selvaraj");
	}
	
	@GetMapping(path= "/person", params="version=2")
	public PersonV2 getpersonRequestParamV2()
	{
		return new PersonV2(new Name("arthi"," selvaraj"));
	}
}
