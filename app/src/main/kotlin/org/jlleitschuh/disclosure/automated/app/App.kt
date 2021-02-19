/*
 * This Kotlin source file was generated by the Gradle 'init' task.
 */
package org.jlleitschuh.disclosure.automated.app

import com.github.ajalt.clikt.core.CliktCommand
import com.github.ajalt.clikt.parameters.options.required
import org.jlleitschuh.disclosure.automated.driver.selenium.GitHubSecurityAdvisoriesSeleniumDriver
import com.github.ajalt.clikt.parameters.options.option as option1

class AutomatedDisclosure : CliktCommand() {
    private val username: String by option1(help = "GitHub Username", envvar = "GIT_HUB_USERNAME").required()
    private val password: String by option1(help = "GitHub Password", envvar = "GIT_HUB_PASSWORD").required()

    override fun run() {
        GitHubSecurityAdvisoriesSeleniumDriver.create().use {
            it.login(username, password)
        }
    }
}

fun main(argv: Array<out String>) {
    AutomatedDisclosure().main(argv)
}
