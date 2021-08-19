package com.epam.tc.hw5.cucumber.exercise2.steps;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import java.util.List;
import java.util.Map;
import org.assertj.core.api.Assertions;

public class ResultStep extends AbstractStep {

    @Then("'User Table' page should be opened")
    public void assertPageTitle() {
        String expectedTitle = "User Table";
        String actualTitle = userTablePage.getPageTitle();
        Assertions.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @And("6 Number Type Dropdowns should be displayed on Users Table on User Table Page")
    public void assertSixDropdownDisplayed() {
        Integer expectedNumber = 6;
        Integer actualNumber = userTablePage.getUserTypeDropdownsList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("6 Usernames should be displayed on Users Table on User Table Page")
    public void assertSixUsernamesDisplayed() {
        Integer expectedNumber = 6;
        Integer actualNumber = userTablePage.getUserNamesList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("6 Description texts under images should be displayed on Users Table on User Table Page")
    public void assertSixDescriptionsDisplayed() {
        Integer expectedNumber = 6;
        Integer actualNumber = userTablePage.getUserDescList().size();
        Assertions.assertThat(actualNumber).isEqualTo(expectedNumber);
    }

    @And("6 checkboxes should be displayed on Users Table on User Table Page")
    public void assertSixCheckboxesDisplayed() {
        Integer expectedNumber = 6;
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
}
