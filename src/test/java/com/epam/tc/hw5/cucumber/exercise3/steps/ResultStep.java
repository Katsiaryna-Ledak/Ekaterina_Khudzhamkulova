package com.epam.tc.hw5.cucumber.exercise3.steps;

import io.cucumber.java.en.Then;
import org.assertj.core.api.Assertions;

public class ResultStep extends AbstractStep {

    @Then("1 log row has {string} text in log section")
    public void assertVipLogDisplayed(String expectedVipLog) {
        String logs = userTablePage.getLogVipCheckboxForSergeyIvan();
        Assertions.assertThat(logs.contains(expectedVipLog));
    }


}
