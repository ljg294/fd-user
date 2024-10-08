package com.fitdine.user.api.server.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Profile
import org.springframework.web.filter.CommonsRequestLoggingFilter

@Configuration
class RequestLoggingFilterConfig {

    @Bean
    @Profile("test", "local")
    fun commonsRequestLoggingFilter(): CommonsRequestLoggingFilter {
        val loggingFilter = CommonsRequestLoggingFilter()
        loggingFilter.setIncludeHeaders(true)         // 헤더 정보를 로그에 포함한다.
        loggingFilter.setIncludeQueryString(true)     // 쿼리 문자열을 로그 메시지에 포함한다.
        loggingFilter.setIncludePayload(true)         // request 내용을 로그에 포함한다.
        loggingFilter.setIncludeClientInfo(true)      // 클라이언트 주소와 세션 ID를 로그 메시지에 포함한다.
        loggingFilter.setMaxPayloadLength(1000)       // 로그의 최대 길이를 설정한다.
        loggingFilter.setBeforeMessagePrefix("RequestLoggingFilter > Before : ")
        loggingFilter.setBeforeMessageSuffix("")
        loggingFilter.setAfterMessagePrefix("RequestLoggingFilter > After : ")
        loggingFilter.setAfterMessageSuffix("")
        return loggingFilter
    }
}