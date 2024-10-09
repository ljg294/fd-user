package com.fitdine.user.api.server.common.converter

import java.time.format.DateTimeFormatter

object DefaultDateTimeFormat {

    val DATE_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
    val TIME_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss")

    val DATE_TIME_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")

    val DATE_NONE_DASH_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd")

    val DATE_TIME_NONE_DASH_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss")

    val YEAR_MONTH_NONE_DASH_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMM")

    val YEAR_MONTH_FORMAT: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM")
}