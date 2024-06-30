package com.srijan.sringboot.myfirstwebapp.todo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ToDoController {
	
	@RequestMapping("todo-list")
	public String sayHelloJsp() {
		return "todo-page";
	}

}
