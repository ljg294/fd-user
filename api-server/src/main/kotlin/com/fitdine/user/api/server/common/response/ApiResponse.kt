package com.fitdine.user.api.server.common.response

import com.fitdine.user.api.server.common.code.ApiResponseCode

data class ApiResponse<T>(
    var code: String? = null,
    var message: String? = null,
    var data: T? = null
) {

    constructor(apiResponseCode: ApiResponseCode) : this(
        code = apiResponseCode.code,
        message = apiResponseCode.defaultMessage
    )

    constructor(apiResponseCode: ApiResponseCode, responseMessage: String?, data: T?) : this(
        code = apiResponseCode.code,
        message = responseMessage ?: apiResponseCode.defaultMessage,
        data = data
    )
}