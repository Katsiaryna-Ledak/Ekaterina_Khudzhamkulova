package com.epam.tc.hw5.cucumber.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;

public class ResultStep extends AbstractStep {

    protected static final List<String> LOG_TEXT_ITEMS = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");

    @Then("Log rows are displayed on Different Elements page")
    public void checkLogTexts() {

        List<String> actualLogList = differentElementsPage.getLogList();
        for (String expectedLogItem : LOG_TEXT_ITEMS) {

            for (String actualLogItem : actualLogList) {
                Assertions.assertThat(expectedLogItem.equals(actualLogItem));
            }
        }
    }

    @Then("'User Table' page should be opened")
    public void assertPageTitle() {
        String expectedTitle = "User Table";
        String actualTitle = userTablePage.getPageTitle();
        Assertions.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @And("{int} Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertSixDropdownDisplayed(int expectedNumber) {
        Integer actualNumber = userTablePage.getUserTypeDropdownsList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("{int} Usernames should be displayed on Users Table on User Table Page")
    public void assertSixUsernamesDisplayed(int expectedNumber) {
        Integer actualNumber = userTablePage.getUserNamesList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("{int} Description texts under images should be displayed on Users Table on User Table Page")
    public void assertSixDescriptionsDisplayed(int expectedNumber) {
        Integer actualNumber = userTablePage.getUserDescList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("{int} checkboxes should be displayed on Users Table on User Table Page")
    public void assertSixCheckboxesDisplayed(int expectedNumber) {
        Integer actualNumber = userTablePage.getUserCheckboxesList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("User table should contain following values:")
    public void assertUserInfo(DataTable dataTable) {
        List<Map<String, String>> table = dataTable.asMaps(String.class, String.class);

        for (int i = 0; i < table.size(); i++) {

            String actualUserNumber = userTablePage.getUserNumberList().get(i);
            String expectedUserNumber = table.get(i).get("Number");
            Assertions.assertThat(actualUserNumber).isEqualTo(expectedUserNumber);

            String actualUserName = userTablePage.getUserNamesList().get(i);
            String expectedUsername = table.get(i).get("User");
            Assertions.assertThat(actualUserName).isEqualTo(expectedUsername);

            String actualUserDesc = userTablePage.getUserDescList().get(i);
            String actualString;
            String expectedUserDesc = table.get(i).get("Description");

            if (actualUserDesc.contains("Hulk") || (actualUserDesc.contains("Captain"))) {
                actualString = actualUserDesc.replace("\n", " ");
                Assertions.assertThat(actualString).isEqualTo(expectedUserDesc);
            }
        }
    }

    @And("droplist should contain values in column Type for user Roman")
    public void assertTypesForRoman(DataTable dataTable) {
        List<String> table = dataTable.asList(String.class);

        for (int i = 0; i < table.size() - 1; i++) {
            String actualDropdownValue = userTablePage.getDropdownValuesForUserRoman().get(i);
            String expectedDropdownValue = table.get(i + 1);
            Assertions.assertThat(actualDropdownValue).isEqualTo(expectedDropdownValue);
        }
    }

    @Then("1 log row has {string} text in log section")
    public void assertVipLogDisplayed(String expectedVipLog) {
        String logs = userTablePage.getLogVipCheckboxForSergeyIvan();
        Assertions.assertThat(logs.contains(expectedVipLog));
    }
}
