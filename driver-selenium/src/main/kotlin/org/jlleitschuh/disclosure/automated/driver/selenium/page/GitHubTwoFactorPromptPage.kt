package org.jlleitschuh.disclosure.automated.driver.selenium.page

import org.fluentlenium.core.FluentPage
import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy

@PageUrl("https://github.com/sessions/two-factor")
class GitHubTwoFactorPromptPage : FluentPage() {
    @field:FindBy(id = "otp")
    lateinit var otpField: FluentWebElement

    @field:FindBy(css = "button.btn-primary")
    lateinit var submitButton: FluentWebElement
}
