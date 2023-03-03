package com.in28minutes.rest.webservices.restfulwebservices.service;

import com.in28minutes.rest.webservices.restfulwebservices.model.ResponseObject;
import com.in28minutes.rest.webservices.restfulwebservices.model.Todo;

public interface TodoService {


    ResponseObject getAllTodo(String username);

    ResponseObject addTodo(Todo todo);

    ResponseObject updateTodo(Long id, Todo newTodo);

    ResponseObject deleteTodo(Long id);

    ResponseObject getTodo(Long id);




}
