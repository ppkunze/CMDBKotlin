package com.example.demo.exception

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ControllerAdvice
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.server.ResponseStatusException

@ControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(ResponseStatusException::class)
    fun handleResponseStatusException(ex: ResponseStatusException): ResponseEntity<Map<String, String>> {
        val body = mapOf(
            "status" to ex.statusCode.toString(),
            "reason" to (ex.reason ?: "No reason provided")
        )
        return ResponseEntity(body, ex.statusCode)
    }
}