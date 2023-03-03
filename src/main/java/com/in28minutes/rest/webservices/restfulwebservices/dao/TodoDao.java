package com.in28minutes.rest.webservices.restfulwebservices.dao;

import com.in28minutes.rest.webservices.restfulwebservices.model.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.repository.TodoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class TodoDao {

    private final TodoRepository todoRepository;

    @Autowired
    public TodoDao(TodoRepository todoRepository) {
        this.todoRepository = todoRepository;
    }

    //save todos
    public Todo saveTodo(Todo todo) {
        return todoRepository.save(todo);
    }

    //get todos by id
    public Todo getTodoById(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isEmpty()) {
            return null;
        }
        return optionalTodo.get();
    }

    //get all todos of user by username
    public List<Todo> getAllTodo(String username) {
        return todoRepository.findByUsername(username);
    }

    //update todos
    public Todo updateTodo(Todo todo, Long id) {
        Todo existingTodo = getTodoById(id);
        if (existingTodo != null) {
            existingTodo.setUsername(todo.getUsername());
            existingTodo.setDescription(todo.getDescription());
            existingTodo.setTargetDate(todo.getTargetDate());
            existingTodo.setDone(todo.isDone());
            return todoRepository.save(existingTodo);
        }
        return null;
    }

    //delete todos of user
    public Boolean deleteTodo(Long id) {
        Optional<Todo> optionalTodo = todoRepository.findById(id);
        if (optionalTodo.isPresent()) {
            todoRepository.delete(optionalTodo.get());
            return true;
        }
        return false;
    }


}
