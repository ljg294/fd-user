package com.fitdine.user.domain.entity

import com.fitdine.user.domain.code.Gender
import jakarta.persistence.*
import java.time.LocalDate

@Entity
@Table(name = "\"user\"")
data class UserEntity(

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", nullable = false)
    var userId: Long? = null,

    @Column(name = "email", nullable = false, length = 255)
    var email: String,

    @Column(name = "password", nullable = false, length = 255)
    var password: String,

    @Column(name = "name", nullable = false, length = 100)
    var name: String,

    @Column(name = "age", nullable = false)
    var age: Int,

    @Enumerated(EnumType.STRING)
    @Column(name = "gender", nullable = false)
    var gender: Gender,

    @Column(name = "mobile", nullable = false, length = 20)
    var mobile: String,

    @Column(name = "signup_date", nullable = false)
    var signupDate: LocalDate

) : BaseEntity()
