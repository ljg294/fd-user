package com.fitdine.user.api.server.exception

import com.fitdine.user.api.server.common.code.ApiResponseCode
import com.fitdine.user.api.server.common.exception.DuplicatedEmailException
import com.fitdine.user.api.server.common.exception.UserNotFoundException
import com.fitdine.user.api.server.common.response.ApiResponse
import com.fitdine.user.api.server.common.response.ApiResponseGenerator
import jakarta.servlet.http.HttpServletRequest
import org.apache.coyote.BadRequestException
import org.slf4j.LoggerFactory
import org.springframework.context.ApplicationEventPublisher
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ApiExceptionHandler(private val applicationEventPublisher: ApplicationEventPublisher) {
    private val log = LoggerFactory.getLogger(ApiExceptionHandler::class.java)

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception::class)
    fun handleGeneralException(e: Exception, request: HttpServletRequest): ResponseEntity<ApiResponse<Void>> {
        return handleException(e, ApiResponseCode.SYSTEM_ERROR, HttpStatus.INTERNAL_SERVER_ERROR)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(BadRequestException::class)
    fun handleBadRequestException(e: BadRequestException, request: HttpServletRequest): ResponseEntity<ApiResponse<Void>> {
        return handleException(e, ApiResponseCode.BAD_REQUEST_ERROR, HttpStatus.BAD_REQUEST)
    }

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(DuplicatedEmailException::class)
    fun handleDuplicatedEmailException(e: DuplicatedEmailException, request: HttpServletRequest): ResponseEntity<ApiResponse<Void>> {
        return handleException(e, ApiResponseCode.CONFLICT_ERROR, HttpStatus.BAD_REQUEST)
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException::class)
    fun handleUserNotFoundException(e: UserNotFoundException, request: HttpServletRequest): ResponseEntity<ApiResponse<Void>> {
        return handleException(e, ApiResponseCode.RESOURCE_NOT_FOUND, HttpStatus.NOT_FOUND)
    }

    private fun handleException(e: Exception, apiResponseCode: ApiResponseCode, status: HttpStatus): ResponseEntity<ApiResponse<Void>> {
        log.error("ApiExceptionHandler > ${e.javaClass.simpleName}: {}", e.toString(), e)
        val apiResponse = ApiResponseGenerator.fail(apiResponseCode, e.message.toString())
        return ResponseEntity(apiResponse, status)
    }
}