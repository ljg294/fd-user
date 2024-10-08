package com.fitdine.user.api.server.common.response

import com.fitdine.user.api.server.common.code.ApiResponseCode

object ApiResponseGenerator {

    fun success(): ApiResponse<Void> {
        return ApiResponse(ApiResponseCode.SUCCESS)
    }

    fun <D> success(data: D): ApiResponse<D> {
        return ApiResponse(ApiResponseCode.SUCCESS, ApiResponseCode.SUCCESS.defaultMessage, data)
    }

    fun fail(): ApiResponse<Void> {
        return ApiResponse(ApiResponseCode.UNKNOWN_ERROR)
    }

    fun fail(code: ApiResponseCode): ApiResponse<Void> {
        return ApiResponse(code)
    }

    fun fail(code: ApiResponseCode, msg: String): ApiResponse<Void> {
        return ApiResponse(code, msg, null)
    }
}