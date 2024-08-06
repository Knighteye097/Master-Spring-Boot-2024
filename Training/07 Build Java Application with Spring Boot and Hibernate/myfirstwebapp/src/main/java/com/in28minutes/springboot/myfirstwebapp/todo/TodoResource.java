package com.in28minutes.springboot.myfirstwebapp.todo;

import java.util.List;
import java.util.function.Predicate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TodoResource {
	@Autowired
	private TodoRepository repository;
	
	@GetMapping("/users/{username}/todos")
	public List<Todo> retrieveTodoByUsername(@PathVariable String username){
		return repository.findByUsername(username);
	}
	
	@GetMapping("/users/{username}/todos/{todoId}")
	public Todo retrieveTodoById(@PathVariable String username, @PathVariable int todoId){
		Predicate<? super Todo> predicate = todo -> todo.getId() == todoId;
		return repository.findByUsername(username).stream().filter(predicate).findFirst().get();
	}
	
	@DeleteMapping("/users/{username}/todos/{todoId}")
	public ResponseEntity<Void> deleteTodoById(@PathVariable String username, @PathVariable int todoId){
		repository.deleteById(todoId);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/users/{username}/todos/{todoId}")
	public Todo updateTodoById(@PathVariable String username, @PathVariable int todoId, @RequestBody Todo todo){
		repository.deleteById(todoId);
		repository.save(todo);
		return todo;
	}
	
	@PostMapping("/users/{username}/todos")
	public Todo createTodo(@PathVariable String username, @RequestBody Todo todo) {
		repository.save(todo);
		return todo;
	}
}
