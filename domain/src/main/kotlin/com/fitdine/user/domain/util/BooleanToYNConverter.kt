package com.fitdine.user.domain.util

import jakarta.persistence.AttributeConverter
import jakarta.persistence.Converter

@Converter(autoApply = true)
class BooleanToYNConverter : AttributeConverter<Boolean, String> {
    override fun convertToDatabaseColumn(attribute: Boolean?): String {
        return if (attribute == true) "Y" else "N"
    }

    override fun convertToEntityAttribute(dbData: String?): Boolean {
        return dbData == "Y"
    }
}