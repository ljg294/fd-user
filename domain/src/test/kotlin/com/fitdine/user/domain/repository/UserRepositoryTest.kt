package com.fitdine.user.domain.repository

import com.fitdine.user.domain.DomainIntegrationTest
import com.fitdine.user.domain.code.Gender
import com.fitdine.user.domain.config.DomainConfig
import com.fitdine.user.domain.entity.UserEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.mockito.Mockito.*
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.boot.test.mock.mockito.MockBean
import java.time.LocalDate
import java.util.Optional

@DomainIntegrationTest
class UserRepositoryTest {

    @MockBean
    private lateinit var userRepository: UserRepository

    private lateinit var user: UserEntity

    @BeforeEach
    fun setup() {
        // Initialize a test user
        user = UserEntity(
            userId = 1,
            email = "user1@gmail.com",
            password = "hashed_password_123",
            name = "홍길동",
            age = 20,
            gender = Gender.MALE,
            mobile = "010-1234-5678",
            signupDate = LocalDate.now() // Use LocalDateTime instead of LocalDate
        )
    }

    @Test
    fun `find user by id`() {
        // Given
        `when`(userRepository.findById(user.userId!!)).thenReturn(Optional.of(user))

        // When
        val foundUser = userRepository.findById(user.userId!!)

        // Then
        assertTrue(foundUser.isPresent)
        assertEquals("user1@gmail.com", foundUser.get().email)
        assertEquals("홍길동", foundUser.get().name)
    }

    @Test
    fun `should return empty optional when user not found`() {
        // Given
        `when`(userRepository.findById(2L)).thenReturn(Optional.empty())

        // When
        val foundUser = userRepository.findById(2L)

        // Then
        assertFalse(foundUser.isPresent)
    }
}