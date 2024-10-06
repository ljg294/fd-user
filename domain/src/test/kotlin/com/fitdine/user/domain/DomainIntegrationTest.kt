package com.fitdine.user.domain

import com.fitdine.user.domain.config.DomainConfig
import org.junit.jupiter.api.Tag
import org.springframework.boot.test.autoconfigure.orm.jpa.AutoConfigureDataJpa
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles

@Target(AnnotationTarget.CLASS)
@Retention(AnnotationRetention.RUNTIME)
@Tag("integration-test")
@ActiveProfiles("test")
@SpringBootTest(classes = [DomainConfig::class])
@AutoConfigureDataJpa
annotation class DomainIntegrationTest