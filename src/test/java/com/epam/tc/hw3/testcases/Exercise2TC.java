package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPanlComponent;
import com.epam.tc.hw3.util.PropertiesFileReader;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.testng.annotations.Test;

public class Exercise2TC extends InitializationTest {

    @Test
    public void ex2HW3EpamPageTest() {

        LoginPanlComponent loginPage = new LoginPanlComponent(webDriver);

        // Open test site by URL
        webDriver.navigate().to(SITE_URL);

        // Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(BROWSER_TITLE);

        PropertiesFileReader fileReader = new PropertiesFileReader();
        // Perform login
        String login = fileReader.getProperties("userName");
        String password = fileReader.getProperties("userPassword");
        loginPage.performLogin(login, password);

        // Open through the header menu Service -> Different Elements Page
        DifferentElementsPage diffElementsPage = new DifferentElementsPage(webDriver);
        HomePage homePage = new HomePage(webDriver);
        homePage.clickOnServiceDiffElementsHead();

        // Select checkboxes Water and Wind
        diffElementsPage.selectWaterCheckBox();
        diffElementsPage.selectWindCheckbox();

        // Select radio Selen
        diffElementsPage.selectSelenRadio();

        // Select in dropdown Yellow
        diffElementsPage.selectYellowInDropdown();

        // Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value
        List<String> actualLogList = diffElementsPage.getLogList();
        for (String expectedLogText : LOG_TEXT_ITEMS) {

            for (String actualLogText : actualLogList) {
                Assertions.assertThat(expectedLogText.equals(actualLogText));
            }
        }
    }
}
