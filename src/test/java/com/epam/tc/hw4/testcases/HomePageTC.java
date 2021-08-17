package com.epam.tc.hw4.testcases;

import com.epam.tc.hw4.steps.Exercise1Steps;
import com.epam.tc.hw4.util.PropertiesFileReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Test;

public class HomePageTC extends InitializationTest {

    @Feature("HomePage Test")
    @Story("User is logging in to HomePage and selects elements on the page")
    @Test
    public void homePageEpamTest() {

        Exercise1Steps steps1 = new Exercise1Steps(webDriver);

        // Open test site by URL
        steps1.openSiteByUrl(webDriver);

        // Assert Browser title
        steps1.assertBrowserTitle(BROWSER_TITLE);

        // Perform login
        PropertiesFileReader fileReader = new PropertiesFileReader();
        String login = fileReader.getProperties("userName");
        String password = fileReader.getProperties("userPassword");
        steps1.performLogin(login, password);

        // Assert User name in the left-top side of screen that user is loggined ("ROMAN IOVLEV")
        String userLogin = fileReader.getProperties("userLogin");
        steps1.assertUserName(userLogin);

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        steps1.assertFourHeaderItems(NAV_BAR_NAMES);

        // Assert that there are 4 images on the Index Page and they are displayed
        steps1.assertFourImages();

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        steps1.assertFourBenefitText(BENEFIT_TEXTS);

        // Assert that there is the iframe with “Frame Button” exist
        steps1.assertIFrame();
        steps1.assertFrameButton();

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        steps1.assertFivesideBarItems(LEFT_SIDE_BAR_MENU_ITEMS);

        // Close Browser
    }
}
