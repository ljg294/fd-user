description = "api-server module"

plugins {
    application
}

springBoot {
    mainClass = "com.fitdine.user.api.server.ApiServerApplication"
}

dependencies {
    implementation(project(":domain"))

    implementation("org.springframework.data:spring-data-commons")

    testImplementation(platform("org.junit:junit-bom:5.10.0"))
    testImplementation("org.junit.jupiter:junit-jupiter")
}