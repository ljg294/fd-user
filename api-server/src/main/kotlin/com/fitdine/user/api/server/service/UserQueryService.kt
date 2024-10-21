package com.fitdine.user.api.server.service

import com.fitdine.user.api.server.common.exception.UserNotFoundException
import com.fitdine.user.api.server.dto.reqeust.UserDetailResponse
import com.fitdine.user.api.server.repository.query.UserQueryRepository
import org.springframework.stereotype.Service

@Service
class UserQueryService(
    private val userQueryRepository: UserQueryRepository
) {

    fun findUserDetail(userId: Long) : UserDetailResponse?{
        return userQueryRepository.findUserDetailById(userId) ?: throw UserNotFoundException()
    }

}