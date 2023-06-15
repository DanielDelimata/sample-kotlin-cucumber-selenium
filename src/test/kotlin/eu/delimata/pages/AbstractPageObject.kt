package eu.delimata.pages

import org.openqa.selenium.WebDriver
import org.openqa.selenium.support.PageFactory
import org.openqa.selenium.support.pagefactory.AjaxElementLocatorFactory

open class AbstractPageObject(private var driver: WebDriver?) {
    init {
        val ajaxElementLocatorFactory = AjaxElementLocatorFactory(driver, 1)
        PageFactory.initElements(ajaxElementLocatorFactory, this)
    }
}