package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.pages.HomePage;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTC extends InitializationTest {

    @Test
    public void ex1HW3EpamPageTest() {

        HomePage homePage = new HomePage(webDriver);

        // Open test site by URL
        webDriver.navigate().to(siteURL);

        // Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(browserTitle);

        // Perform login
        homePage.performLogin(userName, userPswd);

        // Assert User name in the left-top side of screen that user is loggined ("ROMAN IOVLEV")
        String actualName = homePage.getLoggedInUserName();
        Assertions.assertThat(actualName.equals(userLogin));

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        List<String> actualNavBarElements = homePage.getNavBarItemsNames();

        Integer expectedCountOfNavBarItems = navBarNames.size();
        Integer actualCountOfNavBarItems = homePage.getNavBarItemsNames().size();

        // check count of items
        Assertions.assertThat(expectedCountOfNavBarItems.equals(actualCountOfNavBarItems));
        // check texts of items
        for (String expectedNavBarItem : navBarNames) {

            for (String actualNavBarItem : actualNavBarElements) {
                Assertions.assertThat(expectedNavBarItem.equals(actualNavBarItem));
            }
        }

        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexImagesList = homePage.getIndexImages();
        int expectedIndexImagesNumber = 4;
        Assertions.assertThat(indexImagesList.size()).isEqualTo(expectedIndexImagesNumber);
        for (WebElement image : indexImagesList) {
            Assertions.assertThat(image.isDisplayed());
        }

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<String> actualBenefitTexts = homePage.textUnderIndexImages();
        Integer expCountOfTexts = benefitTexts.size();
        Integer actCountOfTexts = actualBenefitTexts.size();
        //check count of texts under images
        Assertions.assertThat(expCountOfTexts.equals(actCountOfTexts));
        //check content of texts under images
        for (String expTextItem : benefitTexts) {

            for (String actTextItem : actualBenefitTexts) {
                Assertions.assertThat(expTextItem.equals(actTextItem));
            }
        }

        // Assert that there is the iframe with “Frame Button” exist
        Assertions.assertThat(homePage.getFrameElement().isEnabled());
        Assertions.assertThat(homePage.getFrameElement().isDisplayed());
        WebElement iframe = homePage.getFrameElement();

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        String startWindowPage = webDriver.getWindowHandle();
        webDriver.switchTo().frame(iframe);
        Assertions.assertThat(homePage.getFrameButton().isEnabled());

        // Switch to original window back
        webDriver.switchTo().window(startWindowPage);

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> sideBarItems = homePage.getLeftSideBarItems();
        Integer expectedCountOfLeftSideBarItems = leftSideBarMenuItems.size();
        Integer actualCountOfLeftSideBarItems = sideBarItems.size();

        // check count of items
        Assertions.assertThat(expectedCountOfLeftSideBarItems.equals(actualCountOfLeftSideBarItems));
        // check texts of items
        for (String expectedLeftSideBarItem : leftSideBarMenuItems) {

            for (String actualLeftSideBarItem : sideBarItems) {
                Assertions.assertThat(expectedLeftSideBarItem.equals(actualLeftSideBarItem));
            }
        }

        // Close Browser
    }
}
