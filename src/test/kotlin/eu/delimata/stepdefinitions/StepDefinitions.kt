package eu.delimata.stepdefinitions

import eu.delimata.pages.CustomersPage
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When
import org.assertj.core.api.Assertions

class StepDefinitions() {

    private lateinit var customersPage: CustomersPage
    private lateinit var searchSummaryAtVeryBeginning: String


    @Given("the user is on the page")
    fun theUserIsOnThePage() {
        customersPage = CustomersPage()
        customersPage.open()
        searchSummaryAtVeryBeginning = customersPage.summaryText
    }

    @When("the user enters the value {string} in the text-input")
    fun theUserEntersTheValueInTheTextInput(searchInput: String?) {
        customersPage.setSearchInput(searchInput)
    }

    @When("the user selects value {string} in the drop-down")
    fun theUserSelectsValueInTheDropDown(value: String?) {
        customersPage.setSearchColumnDropDownListField(value)
    }

    @When("the user sets case sensitivity switch to {string}")
    fun theUserSetsCaseSensitivitySwitchTo(isCaseSensitive: String?) {
        val value = isCaseSensitive.toBoolean()
        customersPage.setMatchCaseCheckboxField(value)
    }

    @When("the user clears filters")
    fun theUserClearsFilters() {
        customersPage.clickClearFiltersButton()
    }

    @Then("the user should see that search criteria are cleared")
    fun theUserShouldSeeThatSearchCriteriaAreCleared() {
        Assertions.assertThat(customersPage.searchInputText).isEmpty()
    }

    @Then("the user should see that the search result summary is as in the very beginning")
    fun theUserShouldSeeThatTheSearchResultSummaryIsAsInTheVeryBeginning() {
        Assertions
            .assertThat(customersPage.summaryText)
            .isEqualTo(searchSummaryAtVeryBeginning)
    }
}