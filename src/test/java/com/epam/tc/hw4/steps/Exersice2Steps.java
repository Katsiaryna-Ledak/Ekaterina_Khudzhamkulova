package com.epam.tc.hw4.steps;

import com.epam.tc.hw4.pages.DifferentElementsPage;
import com.epam.tc.hw4.pages.HomePage;
import com.epam.tc.hw4.pages.LoginPanelPage;
import io.qameta.allure.Step;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.WebDriver;

public class Exersice2Steps {

    protected HomePage homePage;
    protected LoginPanelPage loginPage;
    protected DifferentElementsPage differentElementsPage;

    public Exersice2Steps(WebDriver webDriver) {
        differentElementsPage = new DifferentElementsPage(webDriver);
        loginPage = new LoginPanelPage(webDriver);
        homePage = new HomePage(webDriver);
    }

    @Step("Open test site by URL")
    public void openSiteByUrl(WebDriver webDriver) {
        homePage.openHomePage();
    }

    @Step("Assert Browser title")
    public void assertBrowserTitle(String expectedTitle) {
        Assertions.assertThat(homePage.getPageTitle()).isEqualTo(expectedTitle);
    }

    @Step("Perform login")
    public void performLogin(String login, String password) {
        loginPage.performLogin(login, password);
    }

    @Step("Assert User name in the left-top side of screen that user is loggined as ROMAN IOVLEV")
    public void assertUserName(String userName) {
        String actualName = loginPage.getLoggedInUserName();
        Assertions.assertThat(actualName.equals(userName));
    }

    @Step("Open through the header menu Service -> Different Elements Page")
    public void openServiceMenu() {
        homePage.clickOnServiceDiffElementsHead();
    }

    @Step("Select checkboxes Water and Wind")
    public void selectWaterAndWindCheckboxes() {
        differentElementsPage.selectWaterCheckBox();
        differentElementsPage.selectWindCheckbox();
    }

    @Step("Select radio Selen")
    public void selectSelenRadio() {
        differentElementsPage.selectSelenRadio();
    }

    @Step("Select in dropdown Yellow")
    public void selectYellowInDropdown() {
        differentElementsPage.selectYellowInDropdown();
    }

    @Step("Assert correct logTexts")
    public void assertLogTexts(List<String> expectedHeaderItemsList) {
        List<String> actualLogList = differentElementsPage.getLogList();
        for (String expectedLogText : expectedHeaderItemsList) {

            for (String actualLogText : actualLogList) {
                Assertions.assertThat(expectedLogText.equals(actualLogText));
            }
        }
    }
}
