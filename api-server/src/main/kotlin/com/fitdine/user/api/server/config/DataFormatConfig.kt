package com.fitdine.user.api.server.config

import com.fasterxml.jackson.databind.MapperFeature
import com.fasterxml.jackson.databind.SerializationFeature
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer
import com.fitdine.user.api.server.common.binder.LocalDateParamBinder
import com.fitdine.user.api.server.common.code.DescriptionCode
import com.fitdine.user.api.server.common.converter.DefaultDateTimeFormat
import com.fitdine.user.api.server.common.converter.DescriptionCodeJsonConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.format.FormatterRegistry
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.ResourceHttpMessageConverter
import org.springframework.http.converter.StringHttpMessageConverter
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import org.springframework.web.servlet.config.annotation.EnableWebMvc
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer
import java.time.LocalDate

@Configuration
@EnableWebMvc
class DataFormatConfig : WebMvcConfigurer {

    override fun addFormatters(registry: FormatterRegistry) {
        registry.addConverter(LocalDateParamBinder())
    }

    override fun configureMessageConverters(converters: MutableList<HttpMessageConverter<*>>) {
        converters.add(MappingJackson2HttpMessageConverter(jackson2ObjectMapperBuilder().build()))
        converters.add(StringHttpMessageConverter())
        converters.add(ResourceHttpMessageConverter())
    }

    @Bean
    fun jackson2ObjectMapperBuilder(): Jackson2ObjectMapperBuilder {
        return Jackson2ObjectMapperBuilder()
            .failOnUnknownProperties(false) // SpringBoot default
            .featuresToDisable(MapperFeature.DEFAULT_VIEW_INCLUSION) // SpringBoot default
            .featuresToEnable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS) // SpringBoot default
            .serializerByType(LocalDate::class.java, LocalDateSerializer(DefaultDateTimeFormat.DATE_FORMAT))
            .deserializerByType(LocalDate::class.java, LocalDateDeserializer(DefaultDateTimeFormat.DATE_FORMAT))
            .serializerByType(DescriptionCode::class.java, DescriptionCodeJsonConverter.Serializer())
            .deserializerByType(Enum::class.java, DescriptionCodeJsonConverter.Deserializer())
    }
}