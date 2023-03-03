package com.in28minutes.rest.webservices.restfulwebservices.service.impl;

import com.in28minutes.rest.webservices.restfulwebservices.dao.TodoDao;
import com.in28minutes.rest.webservices.restfulwebservices.model.ResponseObject;
import com.in28minutes.rest.webservices.restfulwebservices.model.Todo;
import com.in28minutes.rest.webservices.restfulwebservices.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service

public class TodoServiceImpl implements TodoService {
    private final TodoDao todoDao;

    @Autowired
    public TodoServiceImpl(TodoDao todoDao) {
        this.todoDao = todoDao;
    }

    @Override
    public ResponseObject getAllTodo(String username) {
        ResponseObject responseObject = new ResponseObject();
        List<Todo> todos = todoDao.getAllTodo(username);

        if (todos.size() > 0) {
            responseObject.setData(todos);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Here are the list of all Todos of " + username);
        } else {
            responseObject.setData(null);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("No todo record exists in database");
        }
        return responseObject;
    }

    @Override
    public ResponseObject addTodo(Todo todo) {
        ResponseObject responseObject = new ResponseObject();
        Todo todo1 = todoDao.saveTodo(todo);
        if (todo1 != null) {
            responseObject.setData(todo1);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Todo saved successfully");
        } else {
            responseObject.setData(null);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Todo save failed");
        }
        return responseObject;
    }

    @Override
    public ResponseObject updateTodo(Long id, Todo newTodo) {
        ResponseObject responseObject = new ResponseObject();
        Todo todo = todoDao.updateTodo(newTodo, id);

        if (todo != null) {
            responseObject.setData(todo);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Todo updated successfully");
        } else {
            responseObject.setData(null);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Todo don't exists");
        }
        return responseObject;
    }

    @Override
    public ResponseObject deleteTodo(Long id) {
        ResponseObject responseObject = new ResponseObject();
        boolean isTrue = todoDao.deleteTodo(id);
        if (isTrue) {
            responseObject.setData("Todo selected");
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Todo deleted successfully");
        } else {
            responseObject.setData("Todo not selected");
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Todo has failed to get delete");
        }
        return responseObject;
    }

    @Override
    public ResponseObject getTodo(Long id) {
        ResponseObject responseObject = new ResponseObject();

        Todo todos = todoDao.getTodoById(id);

        if (todos != null) {
            responseObject.setData(todos);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("Here are the list of all Todos of " + id);
        } else {
            responseObject.setData(null);
            responseObject.setStatusCode(HttpStatus.OK.value());
            responseObject.setMessage("No todo record exists in database");
        }
        return responseObject;
    }
}



