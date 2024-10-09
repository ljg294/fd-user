package com.fitdine.user.api.server.common.binder

import com.fitdine.user.api.server.common.converter.DefaultDateTimeFormat
import org.springframework.core.convert.converter.Converter
import java.time.LocalDate

class LocalDateParamBinder : Converter<String, LocalDate> {

    override fun convert(source: String): LocalDate? {
        if (source.isEmpty()) {
            return null
        }
        return LocalDate.parse(source, DefaultDateTimeFormat.DATE_FORMAT)
    }
}