package com.example.demo1.domain.exception

import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class GlobalExceptionHandler {

        @ExceptionHandler(ModelNotFoundException::class)
        fun handlerModelNotFoundException(e: ModelNotFoundException): ResponseEntity<ErrorResponse> {
                return ResponseEntity
                        .status(HttpStatus.NOT_FOUND)
                        .body(ErrorResponse(e.message))
        }

        @ExceptionHandler(IllegalStateException::class)
        fun handlerIllegalStateException(e: IllegalStateException): ResponseEntity<ErrorResponse> {
                return ResponseEntity
                        .status(HttpStatus.BAD_REQUEST)
                        .body(ErrorResponse(e.message))
        }
}