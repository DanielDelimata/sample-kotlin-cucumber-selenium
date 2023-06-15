package eu.delimata.pages

import eu.delimata.TestRunner1
import org.openqa.selenium.WebDriver
import org.openqa.selenium.WebElement
import org.openqa.selenium.support.CacheLookup
import org.openqa.selenium.support.FindBy
import org.openqa.selenium.support.ui.Select

class CustomersPage() : AbstractPageObject(TestRunner1.driver) {

    private var driver: WebDriver? = TestRunner1.driver

    @FindBy(id = "clear-button")
    @CacheLookup
    private val clickToClearFilters: WebElement? = null

    @FindBy(id = "search-input")
    @CacheLookup
    private val searchInput: WebElement? = null

    @FindBy(id = "search-column")
    @CacheLookup
    private val searchColumn: WebElement? = null

    @FindBy(id = "match-case")
    @CacheLookup
    private val matchCase: WebElement? = null

    @FindBy(id = "table-resume")
    private val summary: WebElement? = null

    @FindBy(id = "search-slogan")
    private val searchTerm: WebElement? = null

    @FindBy(xpath = "//table")
    private val searchResultsTable: WebElement? = null

    fun clickClearFiltersButton(): CustomersPage {
        clickToClearFilters!!.click()
        return this
    }

    fun setSearchInput(searchInput: String?): CustomersPage {
        this.searchInput!!.sendKeys(searchInput)
        return this
    }

    fun setSearchColumnDropDownListField(value: String?): CustomersPage {
        Select(searchColumn).selectByVisibleText(value)
        return this
    }

    fun setMatchCaseCheckboxField(value: Boolean): CustomersPage {
        if (value != matchCase!!.isSelected) {
            matchCase.click()
        }
        return this
    }

    fun open(): CustomersPage {
        val pageUrl = "https://danieldelimata.github.io/sample-page/"
        driver!!.get(pageUrl)
        return this
    }

    val summaryText: String
        get() = summary!!.text
    val searchTermText: String
        get() = searchTerm!!.getAttribute("innerText")
    val searchInputText: String
        get() = searchInput!!.getAttribute("innerText")
    val searchResultsTableText: String
        get() = searchResultsTable!!.text
}