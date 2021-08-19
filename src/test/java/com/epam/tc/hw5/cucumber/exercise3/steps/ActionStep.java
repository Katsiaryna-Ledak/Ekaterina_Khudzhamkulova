package com.epam.tc.hw5.cucumber.exercise3.steps;

import io.cucumber.java.en.When;

public class ActionStep extends AbstractStep {

    @When("I select 'vip' checkbox for 'Sergey Ivan'")
    public void clickOnVipCheckboxForSergeyIvan() {
        userTablePage.setVipCheckboxForSergeyIvan();
    }

}
