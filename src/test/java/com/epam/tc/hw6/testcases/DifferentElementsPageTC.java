package com.epam.tc.hw6.testcases;

import com.epam.tc.hw6.steps.Exersice2Steps;
import com.epam.tc.hw6.util.PropertiesFileReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class DifferentElementsPageTC extends InitializationTest {

    @Feature("DifferentElementsPage Test")
    @Story("User can choose different elements on the page")
    @Test
    public void differentElementsPageEpamTest() {
        Exersice2Steps steps2 = new Exersice2Steps(webDriver);

        // Open test site by URL
        steps2.openSiteByUrl(webDriver);

        // Assert Browser title
        steps2.assertBrowserTitle(BROWSER_TITLE);

        // Perform login
        PropertiesFileReader fileReader = new PropertiesFileReader();
        String login = fileReader.getProperties("userName");
        String password = fileReader.getProperties("userPassword");
        steps2.performLogin(login, password);

        // Assert User name in the left-top side of screen that user is loggined ("ROMAN IOVLEV")
        String userLogin = fileReader.getProperties("userLogin");
        steps2.assertUserName(userLogin);

        // Open through the header menu Service -> Different Elements Page
        steps2.openServiceMenu();

        // Select checkboxes Water and Wind
        steps2.selectWaterAndWindCheckboxes();

        // Select radio Selen
        steps2.selectSelenRadio();

        // Select in dropdown Yellow
        steps2.selectYellowInDropdown();

        // Assert that
        //for each checkbox there is an individual log row and value is corresponded to the status of checkbox
        //for radio button there is a log row and value is corresponded to the status of radio button
        //for dropdown there is a log row and value is corresponded to the selected value
        steps2.assertLogTexts(LOG_TEXT_ITEMS);

        // Close Browser
    }




}
