package com.fitdine.user.domain.entity

import com.fitdine.user.domain.util.BooleanToYNConverter
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import jakarta.persistence.*

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
abstract class BaseEntity : Serializable {

    @Convert(converter = BooleanToYNConverter::class)
    @Column(name = "delete_yn", nullable = false)
    var isDeleted: Boolean = false

    @CreatedBy
    @Column(name = "created_user_id", nullable = false, columnDefinition = "bigint COMMENT '등록자ID'")
    var createdUserId: Long? = 0

    @CreatedDate
    @Column(name = "created_datetime", nullable = false, columnDefinition = "datetime COMMENT '등록일시'")
    var createdDatetime: LocalDateTime? = null

    @LastModifiedBy
    @Column(name = "modified_user_id", nullable = false, columnDefinition = "bigint COMMENT '수정자ID'")
    var modifiedUserId: Long? = 0

    @LastModifiedDate
    @Column(name = "modified_datetime", nullable = false, columnDefinition = "datetime COMMENT '수정일시'")
    var modifiedDatetime: LocalDateTime? = null

    fun delete() {
        this.isDeleted = true
    }

    fun isDeletedYn(): String {
        return if (this.isDeleted == true) "Y" else "N"
    }
}