package com.in28minutes.rest.webservices.restfulwebservices.user;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.ResponseEntity.BodyBuilder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import jakarta.validation.Valid;

@RestController
public class UserResource {
	
	@Autowired
	private UserDaoService service;
	
	public UserResource(UserDaoService service) {
		super();
		this.service = service;
	}

	@GetMapping("/users")
	public List<User> allUsers()
	{
		return service.findAll();
		
	}
	
	@GetMapping("/users/{id}")
	public User findById(@PathVariable int id)
	{
		 User user = service.findUserById(id);
		if(user==null)
			throw new UserNotFoundException("id:"+id);
		
		return user;
	}
	
	@PostMapping("/users")
	public ResponseEntity<User> createUser(@Valid @RequestBody User user)
	{
		 User newUser = service.createNewUser(user);
		 URI location = ServletUriComponentsBuilder.fromCurrentRequest()
					.path("/{id}")
					.buildAndExpand(newUser.getId())
					.toUri(); 
		 
		return ResponseEntity.created(location).build();
	}
	
	@DeleteMapping("/users/{id}")
	public void deleteById(@PathVariable int id)
	{
		  service.deleteUserById(id);
		
	}
	
 
}
