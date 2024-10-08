import org.springframework.boot.gradle.tasks.bundling.BootJar

description = "domain module"

val jar: Jar by tasks
val bootJar: BootJar by tasks

bootJar.enabled = false
jar.enabled = true

plugins {
    id("org.jetbrains.kotlin.plugin.jpa") version "1.9.25"
}

allOpen {
    annotation("jakarta.persistence.Entity")
    annotation("jakarta.persistence.MappedSuperclass")
    annotation("jakarta.persistence.Embeddable")
}

noArg {
    annotation("jakarta.persistence.Entity")
}

dependencies {

    implementation("org.springframework.boot:spring-boot-starter-data-jpa")
    implementation("org.springframework.boot:spring-boot-starter-web")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin")
    implementation ("com.querydsl:querydsl-core")
    implementation ("com.querydsl:querydsl-jpa:5.0.0:jakarta")

    kapt("com.querydsl:querydsl-apt:5.0.0:jakarta")

    runtimeOnly("org.springframework.boot:spring-boot-devtools")
    runtimeOnly("com.h2database:h2")

    testImplementation("org.springframework.boot:spring-boot-starter-test")
    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
    testImplementation("org.mockito:mockito-core")
}