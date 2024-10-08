package com.fitdine.user.api.server.service

import com.fitdine.user.api.server.common.exception.DuplicatedEmailException
import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.api.server.factory.UserFactory
import com.fitdine.user.api.server.repository.command.UserCommandRepository
import com.fitdine.user.domain.code.Gender
import com.fitdine.user.domain.entity.UserEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserCommandServiceTest {

    @Mock
    private lateinit var userCommandRepository: UserCommandRepository

    @InjectMocks
    private lateinit var userCommandService: UserCommandService

    private lateinit var userCreateRequest: UserCreateRequest

    @BeforeEach
    fun setUp() {
        // Initialize test data
        userCreateRequest = UserCreateRequest(
            email = "test@example.com",
            password = "Password@123",
            name = "Jay",
            age = 30,
            gender = Gender.MALE,
            mobile = "010-1234-5678"
        )
    }

    @Test
    fun `create user successful`() {
        // Arrange
        whenever(userCommandRepository.existsByEmail(userCreateRequest.email)).thenReturn(false)
        val userEntity = UserFactory.make(userCreateRequest)
        whenever(userCommandRepository.save(any(UserEntity::class.java))).thenReturn(userEntity)

        // Act
        userCommandService.createUser(userCreateRequest)

        // Assert
        verify(userCommandRepository, times(1)).save(any(UserEntity::class.java))
    }

    @Test
    fun `create user fails - duplicated email`() {
        // Arrange
        whenever(userCommandRepository.existsByEmail(userCreateRequest.email)).thenReturn(true)

        // Act & Assert
        val exception = assertThrows<DuplicatedEmailException> {
            userCommandService.createUser(userCreateRequest)
        }

        assertEquals("Email is already taken", exception.message)
        verify(userCommandRepository, never()).save(any(UserEntity::class.java))
    }
}