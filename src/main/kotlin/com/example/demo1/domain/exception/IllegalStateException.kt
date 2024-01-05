package com.example.demo1.domain.exception

data class IllegalStateException(val IllegalName:String, val id: Long):RuntimeException(
    " $IllegalName not found with given id($id)"
) {
}
