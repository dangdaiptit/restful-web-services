package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.model.ResponseObject;
import com.in28minutes.rest.webservices.restfulwebservices.model.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/api/v1")
//, produces = "application/json"

public class TodoController {


    private final TodoService todoService;

    @Autowired
    public TodoController(TodoService todoService) {
        this.todoService = todoService;
    }


    @GetMapping("/welcome/{username}")
    public ResponseObject getWelcome(@PathVariable String username) {
        ResponseObject responseObject = new ResponseObject();
        responseObject.setMessage("Success");
        responseObject.setStatusCode(HttpStatus.CREATED.value());
        responseObject.setData("Hello, " + username);
        return responseObject;
    }

    @GetMapping("/users/{username}/todos")
    public ResponseObject getAllTodo(@PathVariable String username) {
        return todoService.getAllTodo(username);
    }

    @PostMapping("/users/todos")
    public ResponseObject saveTodo(@RequestBody Todo todo) {
        return todoService.addTodo(todo);
    }

    @PutMapping("/users/todos/{id}")
    public ResponseObject updateTodo(@PathVariable Long id, @RequestBody Todo todo) {
        return todoService.updateTodo(id, todo);
    }

    @DeleteMapping("/users/todos/{id}")
    public ResponseObject deleteTodo(@PathVariable Long id) {
        return todoService.deleteTodo(id);
    }

    @GetMapping("/users/todos/{id}")
    public ResponseObject getTodo(@PathVariable Long id) {
        return todoService.getTodo(id);
    }


}
