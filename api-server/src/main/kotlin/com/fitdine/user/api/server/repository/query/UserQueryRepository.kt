package com.fitdine.user.api.server.repository.query

import com.fitdine.user.domain.entity.UserEntity
import com.querydsl.core.types.Projections
import org.springframework.data.jpa.repository.support.QuerydslRepositorySupport
import org.springframework.stereotype.Repository

@Repository
class UserQueryRepository : QuerydslRepositorySupport(UserEntity::class.java) {

}