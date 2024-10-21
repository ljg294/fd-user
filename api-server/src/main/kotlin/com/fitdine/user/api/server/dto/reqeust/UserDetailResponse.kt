package com.fitdine.user.api.server.dto.reqeust

import com.fitdine.user.domain.code.Gender

data class UserDetailResponse(

    /** 이메일 */
    var email: String,

    /** 이름 */
    var name: String,

    /** 나이 */
    var age: Int,

    /** 성별 */
    var gender: Gender,

    /** 전화번호 */
    var mobile: String,

)