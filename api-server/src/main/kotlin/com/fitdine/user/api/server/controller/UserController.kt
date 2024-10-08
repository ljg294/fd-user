package com.fitdine.user.api.server.controller

import com.fitdine.user.api.server.common.response.ApiResponse
import com.fitdine.user.api.server.common.response.ApiResponseGenerator
import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.api.server.service.UserCommandService
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Slf4j
class UserController(
    private val userCommandService: UserCommandService
) {

    /**
     * 회원 생성
     *
     * @param userCreateRequest
     * @return
     */
    @PostMapping
    fun createMember(@Valid @RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<ApiResponse<Void>> {
        userCommandService.createUser(userCreateRequest)
        val apiResponse = ApiResponseGenerator.success()
        return ResponseEntity(apiResponse, HttpStatus.OK)
    }
}