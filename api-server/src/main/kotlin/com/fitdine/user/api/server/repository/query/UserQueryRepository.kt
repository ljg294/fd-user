package com.fitdine.user.api.server.repository.query

import com.fitdine.user.api.server.dto.reqeust.UserDetailResponse
import com.fitdine.user.domain.entity.UserEntity
import com.querydsl.core.types.Projections
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository
import com.fitdine.user.domain.entity.QUserEntity.userEntity
import com.querydsl.jpa.impl.JPAQueryFactory
import jakarta.persistence.EntityManager
import jakarta.persistence.PersistenceContext

@Repository
class UserQueryRepository(
    @PersistenceContext private val entityManager: EntityManager
) : QuerydslRepositorySupport(UserEntity::class.java) {

    private val queryFactory: JPAQueryFactory by lazy {
        JPAQueryFactory(entityManager)
    }

    fun findUserDetailById(userId: Long): UserDetailResponse? {
        return queryFactory
            .select(
                Projections.constructor(
                    UserDetailResponse::class.java,
                    userEntity.email,
                    userEntity.name,
                    userEntity.age,
                    userEntity.gender,
                    userEntity.mobile
                )
            )
            .from(userEntity)
            .where(userEntity.userId.eq(userId))
            .fetchOne()
    }
}