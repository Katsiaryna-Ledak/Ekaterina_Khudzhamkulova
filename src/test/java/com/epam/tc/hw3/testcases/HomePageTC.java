package com.epam.tc.hw3.testcases;

import com.epam.tc.hw3.pages.DifferentElementsPage;
import com.epam.tc.hw3.pages.HomePage;
import com.epam.tc.hw3.pages.LoginPanelPage;
import com.epam.tc.hw3.util.PropertiesFileReader;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class HomePageTC extends InitializationTest {

    @Test
    public void ex1ex2HW3EpamPageTest() {

        LoginPanelPage loginPage = new LoginPanelPage(webDriver);

        // Open test site by URL
        webDriver.navigate().to(siteURL);

        // Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(browserTitle);

        PropertiesFileReader fileReader = new PropertiesFileReader();
        // Perform login
        String login = fileReader.getProperties("userName");
        String password = fileReader.getProperties("userPassword");
        loginPage.performLogin(login, password);

        // Assert User name in the left-top side of screen that user is loggined ("ROMAN IOVLEV")
        String actualName = loginPage.getLoggedInUserName();
        String userLogin = fileReader.getProperties("userLogin");
        Assertions.assertThat(actualName.equals(userLogin));

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        HomePage homePage = new HomePage(webDriver);
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


        // ex 2
        // Open through the header menu Service -> Different Elements Page
        DifferentElementsPage diffElementsPage = new DifferentElementsPage(webDriver);
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
        for (String expectedLogText : logTextItems) {

            for (String actualLogText : actualLogList) {
                Assertions.assertThat(expectedLogText.equals(actualLogText));
            }
        }

        // Close Browser
    }
}