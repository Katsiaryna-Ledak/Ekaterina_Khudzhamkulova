package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class ActionStep extends AbstractStep {

    @When("I click on 'Service' button in Header")
    public void clickOnServiceOption() {
        homePage.clickOnServiceOption();
    }

    @And("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableOnServiceHead() {
        homePage.clickOnServiceUserTable();
    }

    @When("I select water checkbox")
    public void clickOnWaterCheckbox() {
        differentElementsPage.selectWaterCheckBox();
    }

    @Then("I select wind checkbox")
    public void clickOnWindCheckbox() {
        differentElementsPage.selectWindCheckbox();
    }

    @Then("I select selen radio button")
    public void clickOnSelenRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @Then("I select yellow color from dropdown list")
    public void clickOnYellowOption() {
        differentElementsPage.selectYellowInDropdown();
    }

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickOnVipCheckboxForSergeyIvan() {
        userTablePage.setVipCheckboxForSergeyIvan();
    }

}
