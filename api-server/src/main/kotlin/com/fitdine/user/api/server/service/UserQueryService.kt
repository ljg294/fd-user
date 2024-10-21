package com.fitdine.user.api.server.service

import com.fitdine.user.api.server.common.exception.DuplicatedEmailException
import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.api.server.dto.reqeust.UserDetailResponse
import com.fitdine.user.api.server.factory.UserFactory
import com.fitdine.user.api.server.repository.command.UserCommandRepository
import com.fitdine.user.api.server.repository.query.UserQueryRepository
import com.fitdine.user.domain.entity.UserEntity
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserQueryService(
    private val userQueryRepository: UserQueryRepository
) {

    fun findUserDetail(userId: Long) : UserDetailResponse?{
        return userQueryRepository.findUserDetailById(userId);
    }

}