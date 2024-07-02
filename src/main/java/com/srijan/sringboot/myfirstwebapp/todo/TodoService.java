package com.srijan.sringboot.myfirstwebapp.todo;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

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
	
	public void deleteById(int id) {
		Predicate<? super Todo> predicate
			= todo-> todo.getId()==id;
		todos.removeIf(predicate);
	}
	
	public Todo findById(int id) {
		final Todo[] result = new Todo[1]; // Array to hold the result

	    todos.forEach(todo -> {
	        if (todo.getId() == id) {
	            result[0] = todo; // Assign the matching todo to the array
	        }
	    });

	    return result[0];
	} 
	
}
