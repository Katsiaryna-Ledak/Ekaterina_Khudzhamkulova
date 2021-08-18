package com.epam.tc.hw5.cucumber.exercise1.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;


public class ActionStep extends AbstractStep {

    @When("I click on 'Different Elements' subcategory in 'Service' button in Header menu")
    public void clickOnDiffElementsOnServiceHead() {
        homePage.clickOnServiceDiffElementsHead();
    }

    @And("I select water checkbox")
    public void clickOnWaterCheckbox() {
        differentElementsPage.selectWaterCheckBox();
    }

    @And("I select wind checkbox")
    public void clickOnWindCheckbox() {
        differentElementsPage.selectWindCheckbox();
    }

    @And("I select selen radio button")
    public void clickOnSelenRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @And("I select yellow color from dropdown list")
    public void clickOnYellowOption() {
        differentElementsPage.selectYellowInDropdown();
    }

}
