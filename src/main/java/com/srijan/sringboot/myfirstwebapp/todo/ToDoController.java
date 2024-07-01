package com.srijan.sringboot.myfirstwebapp.todo;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name")
public class ToDoController {
	
	public ToDoController(TodoService todoService) {
		super();
		this.todoService = todoService;
	}

	private TodoService todoService;
	
	
	@RequestMapping("list-todos")
	public String listAllTodos(ModelMap model) {
		
		List<Todo> todos = todoService.findByUserName("Srijan");
		
		model.addAttribute("todos", todos);
		return "listTodos";
	}
	
	@RequestMapping("add-todo")
	public String showNewTOdoPage() {
		return "todo";
	}

}
