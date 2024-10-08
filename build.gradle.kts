import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	kotlin("jvm") version "1.9.25"
	kotlin("plugin.spring") version "1.9.25" apply false
	id("org.springframework.boot") version "3.3.4" apply false
	id("io.spring.dependency-management") version "1.1.6" apply false
	kotlin("plugin.jpa") version "1.9.25" apply false
	kotlin("kapt") version "2.0.20"
}

val javaVersion = 21

allprojects {
	group = "com.fitdine.user"
	version = "0.0.1-SNAPSHOT"

	tasks.withType(JavaCompile::class.java) {
		options.release.set(javaVersion)
	}
	tasks.withType<Test> {
		useJUnitPlatform()
	}

	tasks.withType<KotlinCompile> {
		kotlinOptions {
			freeCompilerArgs = listOf("-Xjsr305=strict", "-language-version=2.0")
			jvmTarget = "21"
		}
	}

	repositories {
		mavenCentral()
	}
}

subprojects {

	apply {
		plugin("kotlin")
		plugin("kotlin-spring")
		plugin("org.springframework.boot")
		plugin("io.spring.dependency-management")
		plugin("kotlin-allopen")
		plugin("org.jetbrains.kotlin.kapt")
	}

	java {
		toolchain {
			languageVersion = JavaLanguageVersion.of(javaVersion)
		}
	}

	dependencies {
		implementation("org.springframework.boot:spring-boot-starter-data-jpa")
		implementation("org.jetbrains.kotlin:kotlin-reflect")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.mockito:mockito-core")
		testImplementation("org.jetbrains.kotlin:kotlin-test-junit5")
		testImplementation("org.springframework.boot:spring-boot-starter-test")
		testImplementation("org.mockito:mockito-core")
		testImplementation("org.mockito.kotlin:mockito-kotlin:4.0.0")
		testRuntimeOnly("org.junit.platform:junit-platform-launcher")
	}

}