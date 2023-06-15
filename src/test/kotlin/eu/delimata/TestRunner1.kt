package eu.delimata

import io.cucumber.junit.Cucumber
import io.cucumber.junit.CucumberOptions
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.runner.RunWith
import org.openqa.selenium.WebDriver
import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import java.util.*

@RunWith(Cucumber::class)
@CucumberOptions(
    features = ["src/test/resources/features"],
    glue = ["eu.delimata.stepdefinitions"],
    snippets = CucumberOptions.SnippetType.CAMELCASE,
    tags = "not @ignore",
    plugin = ["junit:build/junit", "json:build/cucumber.json", "io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm", "html:build/cucumber-html-report"],
    monochrome = true
)

class TestRunner1 {

    companion object {
        var driver: WebDriver? = null

        @JvmStatic
        @BeforeClass
        fun openTheBrowser(): Unit {
            val options = ChromeOptions().addArguments("--start-maximized").addArguments("--headless")
                .addArguments("--remote-allow-origins=*")
            driver = ChromeDriver(options)
        }

        @JvmStatic
        @AfterClass
        fun closeTheBrowser(): Unit {
            driver?.quit()
        }
    }
}

