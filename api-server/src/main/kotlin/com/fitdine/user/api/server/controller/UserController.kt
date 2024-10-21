package com.fitdine.user.api.server.controller

import com.fitdine.user.api.server.common.response.ApiResponse
import com.fitdine.user.api.server.common.response.ApiResponseGenerator
import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.api.server.dto.reqeust.UserDetailResponse
import com.fitdine.user.api.server.service.UserCommandService
import com.fitdine.user.api.server.service.UserQueryService
import jakarta.validation.Valid
import lombok.RequiredArgsConstructor
import lombok.extern.slf4j.Slf4j
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
@Slf4j
class UserController(
    private val userCommandService: UserCommandService,
    private val userQueryService: UserQueryService
) {

    /**
     * 사용자 생성
     *
     * @param userCreateRequest
     * @return
     */
    @PostMapping
    fun createUser(@Valid @RequestBody userCreateRequest: UserCreateRequest): ResponseEntity<ApiResponse<Void>> {
        userCommandService.createUser(userCreateRequest)
        val apiResponse = ApiResponseGenerator.success()
        return ResponseEntity(apiResponse, HttpStatus.OK)
    }

    /**
     * 사용자 상세 조회
     *
     * @param userId
     * @return
     */
    @GetMapping("/{userId}")
    fun findUserDetail(@PathVariable userId: Long): ResponseEntity<ApiResponse<UserDetailResponse?>> {
        val userDetailResponse = userQueryService.findUserDetail(userId)
        val apiResponse = ApiResponseGenerator.success(userDetailResponse)
        return ResponseEntity(apiResponse, HttpStatus.OK)
    }
}