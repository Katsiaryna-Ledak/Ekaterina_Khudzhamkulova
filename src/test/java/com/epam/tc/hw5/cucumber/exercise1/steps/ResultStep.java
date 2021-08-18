package com.epam.tc.hw5.cucumber.exercise1.steps;

import io.cucumber.java.en.Given;
import java.util.List;
import org.assertj.core.api.Assertions;


public class ResultStep extends AbstractStep {

    @Given("Log rows are displayed on 'Different Elements' page")
    public void checkLogTexts(List<String> expectedLogTexts) {
        List<String> actualLogList = differentElementsPage.getLogList();
        for (String expectedLogText : expectedLogTexts) {

            for (String actualLogText : actualLogList) {
                Assertions.assertThat(expectedLogText.equals(actualLogText));
            }
        }
    }


}
