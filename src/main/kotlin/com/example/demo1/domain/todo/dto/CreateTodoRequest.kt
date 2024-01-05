package com.example.demo1.domain.todo.dto

import org.springframework.context.annotation.Description
import java.util.Date

data class CreateTodoRequest(
    val nickname: String,
    val title: String,
    val description: String?,
    val day: Date
)
