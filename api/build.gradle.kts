val kotlin_version: String by project
val logback_version: String by project

plugins {
    kotlin("jvm") version "2.1.10"
    id("org.jetbrains.kotlin.plugin.serialization") version "1.9.20" // Or your specific version
    id("io.ktor.plugin") version "3.2.2"
}

group = "com.sayesamanappointmentbookingsystem"
version = "0.0.1"

application {
    mainClass = "io.ktor.server.netty.EngineMain"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-server-core-jvm")
    implementation("io.ktor:ktor-server-netty")
    implementation("ch.qos.logback:logback-classic:$logback_version")
    implementation("io.ktor:ktor-server-core")
    implementation("io.ktor:ktor-server-config-yaml")
    testImplementation("io.ktor:ktor-server-test-host")
    testImplementation("org.jetbrains.kotlin:kotlin-test-junit:$kotlin_version")

    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation("org.jetbrains.exposed:exposed-core:0.38.2")
    implementation("org.jetbrains.exposed:exposed-dao:0.38.2")
    implementation("org.jetbrains.exposed:exposed-jdbc:0.38.2")
    implementation("mysql:mysql-connector-java:8.0.33") // or a more recent version
    implementation("com.zaxxer:HikariCP:5.0.1") // Optional, for connection pooling
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")

}
