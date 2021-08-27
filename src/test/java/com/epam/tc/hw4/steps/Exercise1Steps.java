package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.pages.LoginPanelComponent;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class Exercise1Steps {

    protected HomePage homePage;
    protected LoginPanelComponent loginPanel;

    public Exercise1Steps(WebDriver webDriver) {
        loginPanel = new LoginPanelComponent(webDriver);
        homePage = new HomePage(webDriver);
    }

    @Step("Open test site by URL")
    public void openSiteByUrl(WebDriver webDriver) {
        homePage.openHomePage();
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        String actualTitle = homePage.getPageTitle();
        Assertions.assertThat(actualTitle).isEqualTo(expectedTitle);
    }

    @Step("Perform login")
    public void performLogin(String login, String password) {
        loginPanel.performLogin(login, password);
    }

    @Step("Assert User name in the left-top side of screen that user is loggined as ROMAN IOVLEV")
    public void assertUserName(String userName) {
        String actualName = loginPanel.getLoggedInUserName();
        Assertions.assertThat(actualName.equals(userName));
    }

    @Step("Assert User name in the left-top side of screen that user is loggined as KATE KHUD")
    public void assertFailureUserName(String userName) {
        String actualName = loginPanel.getLoggedInUserName();
        Assertions.assertThat(actualName.equals(userName));
    }

    @Step("Assert that there are 4 items on the header section are displayed and they have proper texts")
    public void assertFourHeaderItems(List<String> expectedHeaderItemsList) {
        List<String> actualNavBarElements = homePage.getNavBarItemsNames();

        Integer expectedCountOfNavBarItems = expectedHeaderItemsList.size();
        Integer actualCountOfNavBarItems = actualNavBarElements.size();
        // check count of items
        Assertions.assertThat(expectedCountOfNavBarItems.equals(actualCountOfNavBarItems));
        // check texts of items
        for (String item : expectedHeaderItemsList) {

            for (String actualNavBarItem : actualNavBarElements) {
                Assertions.assertThat(item.equals(actualNavBarItem));
            }
        }
    }

    @Step("Assert that there are 4 images on the Index Page and they are displayed")
    public void assertFourImages() {
        List<WebElement> indexImagesList = homePage.getIndexImages();
        int expectedIndexImagesNumber = 4;
        Assertions.assertThat(indexImagesList.size()).isEqualTo(expectedIndexImagesNumber);
        for (WebElement image : indexImagesList) {
            Assertions.assertThat(image.isDisplayed());
        }
    }

    @Step("Assert that there are 4 texts on the Index Page under icons and they have proper text")
    public void assertFourBenefitText(List<String> expectedBenefitTexts) {
        List<String> actualBenefitTexts = homePage.textUnderIndexImages();

        Integer expCountOfTexts = expectedBenefitTexts.size();
        Integer actCountOfTexts = actualBenefitTexts.size();
        //check count of texts under images
        Assertions.assertThat(expCountOfTexts.equals(actCountOfTexts));
        //check content of texts under images
        for (String expTextItem : expectedBenefitTexts) {

            for (String actTextItem : actualBenefitTexts) {
                Assertions.assertThat(expTextItem.equals(actTextItem));
            }
        }
    }

    @Step("Assert that there is the iframe")
    public void assertIFrame() {
        Assertions.assertThat(homePage.getFrameElement().isDisplayed());
    }

    @Step("Assert that there is the iframe with “Frame Button” exist")
    public void assertFrameButton() {
        Assertions.assertThat(homePage.getFrameElement().isDisplayed());
    }

    @Step("Assert that there are 5 items in the Left Section are displayed and they have proper text")
    public void assertFivesideBarItems(List<String> expectedSideBarItems) {
        List<String> actualSideBarItems = homePage.getLeftSideBarItems();

        Integer expectedCountOfLeftSideBarItems = expectedSideBarItems.size();
        Integer actualCountOfLeftSideBarItems = actualSideBarItems.size();
        // check count of items
        Assertions.assertThat(expectedCountOfLeftSideBarItems.equals(actualCountOfLeftSideBarItems));
        for (String expectedLeftSideBarItem : expectedSideBarItems) {

            for (String actualLeftSideBarItem : actualSideBarItems) {
                Assertions.assertThat(expectedLeftSideBarItem.equals(actualLeftSideBarItem));
            }
        }
    }

}
