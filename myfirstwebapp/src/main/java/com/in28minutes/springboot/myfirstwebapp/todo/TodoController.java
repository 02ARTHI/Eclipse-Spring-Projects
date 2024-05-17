package com.in28minutes.springboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

//@Controller
@SessionAttributes("name")
public class TodoController {
       
	private TodoService todoservice;
	
	
	public TodoController(TodoService todoservice) {
		super();
		this.todoservice = todoservice;
	}
    

	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model)
	{
		String username =getLoggedInUsername(model);
		List <Todo> todos = todoservice.findByUserName(username);
		model.put("todos",todos);
		return "listTodos";
	}


	private String getLoggedInUsername(ModelMap model) {
		Authentication authentication = 
				SecurityContextHolder.getContext().getAuthentication();
		return authentication.getName();
	}
	
	//GET,POST
	@RequestMapping(value="add-todo", method= RequestMethod.GET)
	public String shownewTodo( ModelMap model)
	{
		String username =getLoggedInUsername(model);
		Todo todo=new Todo(0,username,"",LocalDate.now().plusYears(1),true);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method= RequestMethod.POST)
	public String addnewTodo( ModelMap model,@Valid Todo todo, BindingResult result)
	{
		if(result.hasErrors())
		{
			return "todo";
		}
		String username =getLoggedInUsername(model);
		todoservice.addtodo(username, todo.getDescription(), todo.getTargetDate(), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deletTodo(@RequestParam int id)
	{
		todoservice.deleteById(id);
		return "redirect:list-todos";
	}
	
	@RequestMapping(value="update-todo" ,method=RequestMethod.GET)
	public String ShowUpdateTodoPage(@RequestParam int id,ModelMap model)
	{
		Todo todo = todoservice.findById(id);
		model.addAttribute("todo",todo);
		return "todo";
	}
	
	@RequestMapping(value="update-todo", method = RequestMethod.POST)
	public String updateTodo(ModelMap model, @Valid Todo todo, BindingResult result) {
		
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = getLoggedInUsername(model);
		
		todoservice.updateTodo(todo);
		return "redirect:list-todos";
	}
	
	
}
