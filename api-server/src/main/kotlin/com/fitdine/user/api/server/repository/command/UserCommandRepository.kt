package com.fitdine.user.api.server.repository.command


import com.fitdine.user.domain.entity.UserEntity
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserCommandRepository : JpaRepository<UserEntity, Long> {
    fun existsByEmail(email: String): Boolean
}