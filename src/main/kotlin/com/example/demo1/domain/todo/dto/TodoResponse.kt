package com.example.demo1.domain.todo.dto

import java.util.Date

data class TodoResponse(
    val id: Long,
    val title: String,
    val description: String?,
    val day: Date,
    val nickname: String
)
