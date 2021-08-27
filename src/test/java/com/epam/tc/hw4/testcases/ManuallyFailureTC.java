package com.epam.tc.hw4.testcases;

import com.epam.tc.hw4.listeners.ScreenshotListener;
import com.epam.tc.hw4.steps.Exercise1Steps;
import com.epam.tc.hw4.util.PropertiesFileReader;
import io.qameta.allure.Feature;
import io.qameta.allure.Story;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners(ScreenshotListener.class)
public class ManuallyFailureTC extends InitializationTest {

    @Feature("HomePage Test")
    @Story("We assert failure manually using wrong browser title and wrong user information")
    @Test
    public void failureTest() {

        Exercise1Steps steps1 = new Exercise1Steps(webDriver);

        // Open test site by URL
        steps1.openSiteByUrl(webDriver);

        // Assert Browser title
        steps1.assertBrowserTitle("Wrong Title");

        // Perform login
        PropertiesFileReader fileReader = new PropertiesFileReader();
        String login = "Wrong USER";
        String password = "wrongpassword";
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
