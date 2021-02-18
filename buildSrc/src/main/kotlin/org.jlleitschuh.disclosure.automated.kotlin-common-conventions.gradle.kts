import gradle.kotlin.dsl.accessors._0fef08b980ebdb230a330281129fa210.runtimeOnly
import gradle.kotlin.dsl.accessors._58ddb5f0d5c8a05989af2a0d27a23614.implementation

/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    // Apply the org.jetbrains.kotlin.jvm Plugin to add support for Kotlin.
    id("org.jetbrains.kotlin.jvm")
}

repositories {
    // Use JCenter for resolving dependencies.
    jcenter()
}

dependencies {
    constraints {
        // Define dependency versions as constraints
        implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")
        implementation("org.seleniumhq.selenium:selenium-java:3.141.59")
        implementation("org.seleniumhq.selenium:selenium-support:3.141.59")
        runtimeOnly("org.seleniumhq.selenium:selenium-chrome-driver:3.141.59")
    }

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use the Kotlin JDK 8 standard library.
    implementation("org.jetbrains.kotlin:kotlin-stdlib-jdk8")

    // Align versions of all Kotlin components
    implementation(platform("org.jetbrains.kotlin:kotlin-bom"))

    // Use JUnit Jupiter API for testing.
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.2")

    // Use JUnit Jupiter Engine for testing.
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine")
}

tasks.test {
    // Use junit platform for unit tests.
    useJUnitPlatform()
}
