package com.srijan.sringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import jakarta.validation.Valid;

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
	
	@RequestMapping(value="add-todo", method=RequestMethod.GET)
	public String showNewTOdoPage(ModelMap model) {
		String username = (String)model.get("name");
		Todo todo = new Todo(0, username, "", LocalDate.now().plusYears(1), false);
		model.put("todo", todo);
		return "todo";
	}
	
	@RequestMapping(value="add-todo", method=RequestMethod.POST)
	public String addNewTOdo( ModelMap model, @Valid Todo todo, BindingResult result ) {
		if(result.hasErrors()) {
			return "todo";
		}
		
		String username = (String)model.get("name");
		todoService.addTodo(username, todo.getDescription(), 
							LocalDate.now().plusYears(1), false);
		return "redirect:list-todos";
	}
	
	@RequestMapping("delete-todo")
	public String deleteTodo(@RequestParam int id) {
		
		todoService.deleteById(id);
		
		return "redirect:list-todos";
	}

}
