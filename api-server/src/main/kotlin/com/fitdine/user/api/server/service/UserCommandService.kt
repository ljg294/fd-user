package com.fitdine.user.api.server.service

import com.fitdine.user.api.server.common.exception.DuplicatedEmailException
import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.api.server.factory.UserFactory
import com.fitdine.user.api.server.repository.command.UserCommandRepository
import jakarta.transaction.Transactional
import org.springframework.stereotype.Service

@Service
class UserCommandService(
    private val userCommandRepository: UserCommandRepository
) {

    @Transactional
    fun createUser(userCreateRequest: UserCreateRequest) {
        if (isEmailDuplicated(userCreateRequest.email))
            throw DuplicatedEmailException()

        val userEntity = UserFactory.make(userCreateRequest)
        userCommandRepository.save(userEntity)
    }

    private fun isEmailDuplicated(email: String): Boolean {
        return userCommandRepository.existsByEmail(email)
    }
}