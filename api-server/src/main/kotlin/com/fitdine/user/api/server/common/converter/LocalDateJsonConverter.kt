package com.fitdine.user.api.server.common.converter

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.databind.DeserializationContext
import com.fasterxml.jackson.databind.JsonDeserializer
import com.fasterxml.jackson.databind.JsonSerializer
import com.fasterxml.jackson.databind.SerializerProvider
import org.springframework.boot.jackson.JsonComponent
import java.io.IOException
import java.time.LocalDate

@JsonComponent
object LocalDateJsonConverter {

    class Serializer : JsonSerializer<LocalDate>() {
        @Throws(IOException::class)
        override fun serialize(localDate: LocalDate?, jsonGenerator: JsonGenerator, serializerProvider: SerializerProvider) {
            jsonGenerator.writeString(convertDate(localDate))
        }
    }

    class Deserializer : JsonDeserializer<LocalDate>() {
        @Throws(IOException::class)
        override fun deserialize(jsonParser: JsonParser, deserializationContext: DeserializationContext): LocalDate? {
            return convertDate(jsonParser.text)
        }
    }

    private fun convertDate(localDate: LocalDate?): String? {
        return localDate?.format(DefaultDateTimeFormat.DATE_FORMAT)
    }

    private fun convertDate(date: String?): LocalDate? {
        return if (date.isNullOrEmpty()) null else LocalDate.parse(date, DefaultDateTimeFormat.DATE_FORMAT)
    }
}