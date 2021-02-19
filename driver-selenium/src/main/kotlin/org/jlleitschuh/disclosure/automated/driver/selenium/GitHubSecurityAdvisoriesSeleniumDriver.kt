package org.jlleitschuh.disclosure.automated.driver.selenium

import org.fluentlenium.adapter.FluentStandalone
import org.fluentlenium.core.FluentPage
import org.jlleitschuh.disclosure.automated.driver.selenium.page.GitHubLoginPage
import java.util.concurrent.TimeUnit

class GitHubSecurityAdvisoriesSeleniumDriver(
    private val fluentStandalone: FluentStandalone
) : AutoCloseable {

    fun login(username: String, password: String, twoFactorSecret: String) {
        val loginPage = goTo(GitHubLoginPage())
        loginPage.loginField.write(username)
        loginPage.passwordField.write(password)
        loginPage.submitButton.click()
    }

    private fun <P : FluentPage> goTo(page: P): P {
        page.initFluent(fluentStandalone.fluentControl)
        val atPage = fluentStandalone.goTo(page)
        fluentStandalone.await().atMost(5, TimeUnit.SECONDS).untilPage(page).isAt
        fluentStandalone.inject(page)
        return atPage
    }

    override fun close() {
        fluentStandalone.quit()
    }

    companion object {
        fun create(): GitHubSecurityAdvisoriesSeleniumDriver {
            val fluentStandalone = FluentStandalone()
            fluentStandalone.webDriver = "chrome"
            fluentStandalone.init()
            return GitHubSecurityAdvisoriesSeleniumDriver(fluentStandalone)
        }
    }
}
