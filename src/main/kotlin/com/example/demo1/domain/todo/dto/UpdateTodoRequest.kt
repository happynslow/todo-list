package com.example.demo1.domain.todo.dto

data class UpdateTodoRequest(
    val nickname: String,
    val title: String?
    val description: String?
)
