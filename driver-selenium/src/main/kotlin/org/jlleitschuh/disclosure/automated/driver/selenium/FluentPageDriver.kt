package org.jlleitschuh.disclosure.automated.driver.selenium

import org.fluentlenium.adapter.FluentStandalone
import org.fluentlenium.core.FluentPage
import java.util.concurrent.TimeUnit

class FluentPageDriver
private constructor(
    private val fluentStandalone: FluentStandalone
): AutoCloseable {

    fun <P : FluentPage> goTo(page: P): P {
        page.initFluent(fluentStandalone.fluentControl)
        val atPage = fluentStandalone.goTo(page)
        return ensureAt(atPage)
    }

    fun <P : FluentPage> at(page: P): P {
        page.initFluent(fluentStandalone.fluentControl)
        return ensureAt(page)
    }

    private fun <P : FluentPage> ensureAt(page: P): P {
        fluentStandalone.await().atMost(5, TimeUnit.SECONDS).untilPage(page).isAt
        fluentStandalone.inject(page)
        return page
    }

    override fun close() {
        fluentStandalone.quit()
    }

    companion object {
        fun create(): FluentPageDriver {
            val fluentStandalone = FluentStandalone()
            fluentStandalone.webDriver = "chrome"
            fluentStandalone.init()
            return FluentPageDriver(fluentStandalone)
        }
    }
}
