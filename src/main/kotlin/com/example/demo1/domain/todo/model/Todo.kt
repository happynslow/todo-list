package com.example.demo1.domain.todo.model


import com.example.demo1.domain.todo.dto.TodoResponse
import java.util.Date


@Entity
@Table(name = "todo")
class Todo (

    @Column(name = "title")
    var title: String,

    @Column(name = "description")
    var description: String? = null,

    @Column(name = "nickname")
    var nickname: String,

    @Column(name = "day")
    val day: Date
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null
}
fun Todo.toResponse(): TodoResponse {
    return TodoResponse(
        id = id!!,
        title = title,
        description = description,
        day = day,
        nickname = nickname
    )
}