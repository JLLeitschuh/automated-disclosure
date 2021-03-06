/*
 * This file was generated by the Gradle 'init' task.
 */

plugins {
    id("org.jlleitschuh.disclosure.automated.kotlin-application-conventions")
    id("eu.leontebbens.gradle.chromedriver-updater") version "1.6.2"
}

dependencies {
    implementation("com.github.ajalt.clikt:clikt")
    implementation(project(":driver"))
    implementation(project(":driver-selenium"))
    runtimeOnly("org.seleniumhq.selenium:selenium-chrome-driver")
}

application {
    // Define the main class for the application.
    mainClass.set("org.jlleitschuh.disclosure.automated.app.AppKt")
}

tasks.named<JavaExec>("run") {
    dependsOn(tasks.updateChromedriver)
    systemProperties("webdriver.chrome.driver" to tasks.updateChromedriver.map { it.driverLocation}.get())
}
