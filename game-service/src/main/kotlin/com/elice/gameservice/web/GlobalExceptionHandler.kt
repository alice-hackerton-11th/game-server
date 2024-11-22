package com.elice.gameservice.web

import com.elice.common.exception.AuthenticationException
import com.elice.common.exception.ConflictException
import com.elice.common.exception.NotFoundException
import com.elice.common.response.BaseResponse
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.MethodArgumentNotValidException
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice
import org.springframework.web.method.annotation.HandlerMethodValidationException

@RestControllerAdvice
class GlobalExceptionHandler {
    @ExceptionHandler(HandlerMethodValidationException::class)
    @ResponseStatus
    fun handlerMethodValidationException(ex: HandlerMethodValidationException): ResponseEntity<BaseResponse<Any>> {
        val messages = ex.allErrors.map { it.defaultMessage }.joinToString(", ")
        return ResponseEntity.badRequest().body(
            BaseResponse(
                isSuccess = false,
                message = messages,
                code = 4000
            )
        )
    }

    @ExceptionHandler(MethodArgumentNotValidException::class)
    @ResponseBody
    fun handleValidationException(ex: MethodArgumentNotValidException): ResponseEntity<BaseResponse<Any>> {
        val messages = ex.bindingResult.fieldErrors.map { it.defaultMessage }.joinToString(", ")
        return ResponseEntity.badRequest().body(
            BaseResponse(
                isSuccess = false,
                message = messages,
                code = 4000
            )
        )
    }

    @ExceptionHandler(AuthenticationException::class)
    @ResponseBody
    fun handleAuthenticationException(ex: AuthenticationException): ResponseEntity<BaseResponse<Any>> {
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(
            BaseResponse(
                isSuccess = false,
                message = ex.status.message,
                code = ex.status.code
            )
        )
    }

    @ExceptionHandler(ConflictException::class)
    @ResponseBody
    fun handleConflictException(ex: ConflictException): ResponseEntity<BaseResponse<Any>> {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(
            BaseResponse(
                isSuccess = false,
                message = ex.status.message,
                code = ex.status.code
            )
        )
    }

    @ExceptionHandler(NotFoundException::class)
    @ResponseBody
    fun handleNotFoundException(ex: NotFoundException): ResponseEntity<BaseResponse<Any>> {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
            BaseResponse(
                isSuccess = false,
                message = ex.status.message,
                code = ex.status.code
            )
        )
    }
}