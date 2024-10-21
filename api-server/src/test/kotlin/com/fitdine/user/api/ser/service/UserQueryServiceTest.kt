package com.fitdine.user.api.server.service

import com.fitdine.user.api.server.common.exception.DuplicatedEmailException
import com.fitdine.user.api.server.dto.reqeust.UserCreateRequest
import com.fitdine.user.api.server.dto.reqeust.UserDetailResponse
import com.fitdine.user.api.server.factory.UserFactory
import com.fitdine.user.api.server.repository.command.UserCommandRepository
import com.fitdine.user.api.server.repository.query.UserQueryRepository
import com.fitdine.user.domain.code.Gender
import com.fitdine.user.domain.entity.UserEntity
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.kotlin.given
import org.mockito.kotlin.whenever
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserQueryServiceTest {

    @Mock
    private lateinit var userQueryRepository: UserQueryRepository

    @InjectMocks
    private lateinit var userQueryService: UserQueryService

    @Test
    fun `should return UserDetailResponse for valid userId`() {
        // Given
        val userId = 1L
        val expectedUserDetailResponse = UserDetailResponse(
            email = "johndoe@example.com",
            name = "John Doe",
            age = 30,
            gender = Gender.MALE,
            mobile = "010-456-7890"
        )

        given(userQueryRepository.findUserDetailById(userId)).willReturn(expectedUserDetailResponse)

        // When
        val actualUserDetailResponse = userQueryService.findUserDetail(userId)

        // Then
        assertEquals(expectedUserDetailResponse, actualUserDetailResponse)
        verify(userQueryRepository).findUserDetailById(userId)
    }

    @Test
    fun `should return null for invalid userId`() {
        // Given
        val userId = 999L

        given(userQueryRepository.findUserDetailById(userId)).willReturn(null)

        // When
        val actualUserDetailResponse = userQueryService.findUserDetail(userId)

        // Then
        assertNull(actualUserDetailResponse)
        verify(userQueryRepository).findUserDetailById(userId)
    }
}