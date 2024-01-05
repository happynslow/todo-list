package com.example.demo1.domain.todo.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/todo")
@RestController
class TodoController (
    private val todoService: TodoService){


@GetMapping
fun getTodoList(): ResponseEntity<List<TodoResponse>> {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(todoService.getTodoList())
}

@GetMapping("/{todoId")
fun getTodo(@PathVariable todoId: Long): ResponseEntity<TodoResponse> {
    return ResponseEntity
        .status(HttpStatus.OK)
        .body(todoService.getTodo(todoId))

}

@PostMapping
fun createTodo(RequestBody createTodosRequest: CreateTodoRequest): ResponseEntity<TodoResponse> {
    return ResponseEntity
        .status(HttpStatus.CREATED)
        .body(todoService.createTodo(createTodoRequest))
}

@PutMapping("/{todoId")
fun updateTodo(@PathVariable todoId: Long, updateTodoRequest): ResponseEntity<TodoResponse> {
    return  ResponseEntity
        .status(HttpStatus.OK)
        .body((todoService.updateTodo(todoId, updateTodoRequest)))
}

@DeleteMapping("/{todoId")
fun deleteTodos(@PathVariable todoId: Long): ResponseEntity<Unit> {
    todoService.deleteTodo(todoId)
    return ResponseEntity
        .status(HttpStatus.NO_CONTENT)
        .build()
}

}