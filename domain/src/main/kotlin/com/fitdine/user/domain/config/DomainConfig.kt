package com.fitdine.user.domain.config

import org.springframework.boot.autoconfigure.domain.EntityScan
import org.springframework.context.annotation.ComponentScan
import org.springframework.context.annotation.Configuration
import org.springframework.data.jpa.repository.config.EnableJpaAuditing
import org.springframework.data.jpa.repository.config.EnableJpaRepositories

@Configuration
@EnableJpaAuditing
@EntityScan(basePackages = ["com.fitdine.user.domain.entity"])
@EnableJpaRepositories(basePackages = ["com.fitdine.user.domain"])
@ComponentScan(basePackages = ["com.fitdine.user.domain"])
class DomainConfig