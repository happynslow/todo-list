package com.example.demo1.domain.todo.service

import com.example.demo1.domain.todo.dto.CreateTodoRequest
import com.example.demo1.domain.todo.dto.TodoResponse
import com.example.demo1.domain.todo.dto.UpdateTodoRequest

interface TodoService {

    fun getTodoList(): List<TodoResponse>

    fun getTodo(todoId: Long): TodoResponse

    fun createTodo(request: CreateTodoRequest): TodoResponse

    fun updateTodo(todoId: Long, request: UpdateTodoRequest): TodoResponse

    fun deleteTodo(todoId: Long)
}