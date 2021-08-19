package com.epam.tc.hw5.cucumber.exercise1.steps;

import io.cucumber.java.en.Given;
import java.util.Arrays;
import java.util.List;
import org.assertj.core.api.Assertions;

public class ResultStep extends AbstractStep {

    protected static final List<String> LOG_TEXT_ITEMS = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");

    @Given("Log rows are displayed on Different Elements page")
    public void checkLogTexts() {

        List<String> actualLogList = differentElementsPage.getLogList();
        for (String expectedLogItem : LOG_TEXT_ITEMS) {

            for (String actualLogItem : actualLogList) {
                Assertions.assertThat(expectedLogItem.equals(actualLogItem));
            }
        }
    }
}
