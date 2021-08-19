package com.epam.tc.hw5.cucumber.exercise2.steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I click on 'Service' button in Header")
    public void clickOnDiffElementsOnServiceHead() {
        homePage.clickOnServiceDiffElementsHead();
    }

    @And("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableOnServiceHead() {
        homePage.clickOnServiceUserTable();
    }
}
