package org.jlleitschuh.disclosure.automated.driver.selenium

import com.j256.twofactorauth.TimeBasedOneTimePasswordUtil
import org.jlleitschuh.disclosure.automated.driver.selenium.page.GitHubLoginPage
import org.jlleitschuh.disclosure.automated.driver.selenium.page.GitHubTwoFactorPromptPage

class GitHubSecurityAdvisoriesSeleniumDriver(
    private val pageDriver: FluentPageDriver
) : AutoCloseable {

    fun login(username: String, password: String, twoFactorSecret: String) {
        val loginPage = pageDriver.goTo(GitHubLoginPage())
        loginPage.loginField.write(username)
        loginPage.passwordField.write(password)
        loginPage.submitButton.click()
        val twoFactorPage = pageDriver.at(GitHubTwoFactorPromptPage())
        twoFactorPage.otpField.write(TimeBasedOneTimePasswordUtil.generateCurrentNumberString(twoFactorSecret))
        twoFactorPage.submitButton.click()
    }

    override fun close() {
        pageDriver.close()
    }

    companion object {
        fun create(): GitHubSecurityAdvisoriesSeleniumDriver {
            return GitHubSecurityAdvisoriesSeleniumDriver(FluentPageDriver.create())
        }
    }
}
