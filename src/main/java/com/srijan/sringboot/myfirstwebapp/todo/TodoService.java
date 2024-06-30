package com.srijan.sringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
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
