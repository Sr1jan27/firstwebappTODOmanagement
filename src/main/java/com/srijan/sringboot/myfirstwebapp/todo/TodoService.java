package com.srijan.sringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class TodoService {

	private static List<Todo> todos = new ArrayList<>();
	
	public static int todosCount =0;
	
	static {
		todos.add(new Todo(++todosCount, "Srijan", "Learn SpringBoot",
				           LocalDate.now().plusYears(1), false));
		
		todos.add(new Todo(++todosCount, "Srijan", "Learn Angular",
		           LocalDate.now().plusYears(2), false));
		
		todos.add(new Todo(++todosCount, "Srijan", "Learn DSA",
		           LocalDate.now().plusYears(1), false));
	}
	
	public List<Todo> findByUserName(String username){
		return todos;
	}
	
	public void addTodo(String username, String description, LocalDate localDate, boolean done) {
		Todo todo = new Todo(++todosCount, username, description, localDate, done);
		todos.add(todo);
	}
	
}
