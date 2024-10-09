package com.fitdine.user.api.server.common.converter

import com.fasterxml.jackson.core.JsonGenerator
import com.fasterxml.jackson.core.JsonParser
import com.fasterxml.jackson.core.JsonToken
import com.fasterxml.jackson.databind.*
import com.fasterxml.jackson.databind.deser.ContextualDeserializer
import com.fitdine.user.api.server.common.code.DescriptionCode
import org.springframework.boot.jackson.JsonComponent
import java.io.IOException

@JsonComponent
object DescriptionCodeJsonConverter {

    private const val FIELD_CODE = "code"
    private const val FIELD_TEXT = "text"

    class Serializer : JsonSerializer<DescriptionCode>() {
        @Throws(IOException::class)
        override fun serialize(
            code: DescriptionCode,
            jsonGenerator: JsonGenerator,
            serializerProvider: SerializerProvider
        ) {
            jsonGenerator.writeStartObject()
            jsonGenerator.writeStringField(FIELD_CODE, code.code ?: "") // Handles both enum and non-enum cases
            jsonGenerator.writeStringField(FIELD_TEXT, code.description)
            jsonGenerator.writeEndObject()
        }
    }

    class Deserializer(
        private val targetClass: Class<out Enum<*>>? = null
    ) : JsonDeserializer<Enum<*>>(), ContextualDeserializer {

        @Suppress("UNCHECKED_CAST")
        override fun createContextual(ctxt: DeserializationContext, property: BeanProperty?): JsonDeserializer<*> {
            val rawClass = ctxt.contextualType.rawClass
            return Deserializer(rawClass as Class<out Enum<*>>)
        }

        @Throws(IOException::class)
        override fun deserialize(jsonParser: JsonParser, ctxt: DeserializationContext): Enum<*> {
            var code: String? = null

            if (jsonParser.currentToken == JsonToken.VALUE_STRING) {
                code = jsonParser.valueAsString
            } else {
                while (jsonParser.nextToken() != JsonToken.END_OBJECT) {
                    if (jsonParser.currentToken == JsonToken.FIELD_NAME && FIELD_CODE == jsonParser.currentName) {
                        code = jsonParser.nextTextValue()
                    }
                }
            }

            return enumValueOf(targetClass!!, code!!)
        }

        private fun enumValueOf(enumClass: Class<out Enum<*>>, code: String): Enum<*> {
            return java.lang.Enum.valueOf(enumClass, code)
        }
    }
}