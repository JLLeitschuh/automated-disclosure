package org.jlleitschuh.disclosure.automated.driver.selenium.page

import org.fluentlenium.core.FluentPage
import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy

@PageUrl("https://github.com/login")
class GitHubLoginPage : FluentPage() {
    @field:FindBy(id = "login_field")
    lateinit var loginField: FluentWebElement

    @field:FindBy(id = "password")
    lateinit var passwordField: FluentWebElement

    @field:FindBy(id = "submit")
    lateinit var submitButton: FluentWebElement
}
