package com.srijan.sringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.List;

public class TodoService {

	private static List<Todo> todos;
	
	static {
		todos.add(new Todo(1, "Srijan", "Learn SpringBoot",
				           LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(2, "Srijan", "Learn Angular",
		           LocalDate.now().plusYears(2), false));
		
		todos.add(new Todo(3, "Srijan", "Learn DSA",
		           LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUserName(String username){
		return todos;
	}
	
}
