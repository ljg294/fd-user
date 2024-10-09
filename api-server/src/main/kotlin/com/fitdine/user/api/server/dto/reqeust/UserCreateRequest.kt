package com.fitdine.user.api.server.dto.reqeust

import com.fitdine.user.domain.code.Gender
import jakarta.validation.constraints.*

data class UserCreateRequest(

    /** 이메일 */
    @field:Email(message = "올바른 이메일 형식이 아닙니다.")
    @field:Size(max = 100, message = "이메일은 최대 100자 이하 입니다.")
    @field:NotNull(message = "필수 항목입니다")
    var email: String,

    /** 비밀번호 */
    @field:Size(min = 8, max = 100, message = "비밀번호는 최소 8자 이상 100자 이하 입니다.")
    @field:Pattern(
        regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[!@#\$%^&*()])[A-Za-z\\d!@#\$%^&*()]{8,}$",
        message = "비밀번호는 영어, 숫자, 특수문자(!@#\$%^&*())의 조합이어야 합니다."
    )
    @field:NotNull(message = "필수 항목입니다")
    var password: String,

    /** 이름 */
    @field:Size(min = 2, max = 100, message = "회원 이름은 최소 2자 이상 100자 이하 입니다.")
    @field:NotBlank(message = "필수 항목입니다")
    var name: String,

    /** 나이 */
    @field:NotNull(message = "필수 항목입니다")
    var age: Int,

    /** 성별 */
    @field:NotNull(message = "필수 항목입니다")
    var gender: Gender,

    /** 전화번호 */
    @field:Pattern(
        regexp = "^010-\\d{4}-\\d{4}$",
        message = "전화번호는 010-xxxx-xxxx 형식이어야 합니다."
    )
    @field:NotNull(message = "필수 항목입니다")
    var mobile: String,

)