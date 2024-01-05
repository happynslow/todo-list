package com.example.demo1.domain.todo.service

import com.example.demo1.domain.todo.dto.CreateTodoRequest
import com.example.demo1.domain.todo.dto.TodoResponse
import com.example.demo1.domain.todo.dto.UpdateTodoRequest
import com.example.demo1.domain.todo.repositoy.TodoRepository
import org.springframework.stereotype.Service


@Service
class TodoServiceImpl (
    private val todoRepository: TodoRepository,
    ) : TodoService {
    override fun getTodoList(): List<TodoResponse> {
        return todoRepository.findAll(Sort.by(Sort.Direction.DESC, "day")).map { it.toResponse() }
    }

    override fun getTodo(todoId: Long): TodoResponse {
        val todos = todoRepository.findByIdOrNull(todoId) ?: throw ModelNotFoundException("Todo", todoId)
        return todo.toResponse()
    }

    override fun createTodo(request: CreateTodoRequest): TodoResponse {
        return todoRepository.save(
            Todo(
                nickname = request.nickname,
                title = request.title,
                description = request.description,
                day = request.day
            )

        ).toResponse()
    }

    @Transactional
    ovrride fun updateTodo(todosId: Long, request: UpdateTodoRequest): TodosResponse {
        val todos = todoRepository.findByIdOrNull(todosId) ?: throw IllegalStateException("Todo", todoId)
//      val (title, description, nickname) = request
    todo.nickname = request.nickname
        todo.title = request.title
        todo.description = request.description

        return todoRepository.save(todo).toResponse()
        //retun TodoRespinse(1,"","",Date(),"")
    }

    @Transactional
    override fun deleteTodo(todoId: Long) {
        val todo = todoRepository.findByIdOrNull(todoId) ?: throw IllegalStateException("Todo", todoId)
        TodoRepository.delete(todo)
    }
}

