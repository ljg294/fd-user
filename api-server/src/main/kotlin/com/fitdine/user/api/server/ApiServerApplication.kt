package com.fitdine.user.api.server

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ApiServerApplication

fun main(args: Array<String>) {
	runApplication<ApiServerApplication>(*args)
}
