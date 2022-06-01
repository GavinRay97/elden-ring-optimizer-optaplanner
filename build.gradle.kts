import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.6.21"
}

group = "org.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

object Versions {
    const val optaplanner = "8.22.0.Final"
    const val logback = "1.2.9"
    const val jackson = "2.13.3"
}

dependencies {
    implementation(platform("org.optaplanner:optaplanner-bom:${Versions.optaplanner}"))
    implementation("org.optaplanner:optaplanner-core")

    implementation("com.fasterxml.jackson.core:jackson-databind:${Versions.jackson}")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:${Versions.jackson}")

    testImplementation(kotlin("test"))
    testImplementation("org.optaplanner:optaplanner-test")
    runtimeOnly("ch.qos.logback:logback-classic:${Versions.logback}")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
}
