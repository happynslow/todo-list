package com.example.demo1.domain.todo.repositoy

import com.example.demo1.domain.todo.model.Todo

interface TodoRepository : JpaRepository <Todo, Long> {
}