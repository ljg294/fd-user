package com.fitdine.user.api.server.factory

import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.domain.entity.UserEntity
import java.time.LocalDate

object UserFactory {

    fun make(userCreateRequest: UserCreateRequest): UserEntity {
        return UserEntity(
            email = userCreateRequest.email,
            password = userCreateRequest.password,
            name = userCreateRequest.name,
            age = userCreateRequest.age,
            gender = userCreateRequest.gender,
            mobile = userCreateRequest.mobile,
            signupDate = LocalDate.now()
        )
    }
}