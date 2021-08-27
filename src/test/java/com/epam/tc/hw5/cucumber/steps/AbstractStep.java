package com.epam.tc.hw5.cucumber.steps;

import com.epam.tc.hw5.pages.DifferentElementsPage;
import com.epam.tc.hw5.pages.HomePage;
import com.epam.tc.hw5.pages.LoginPanelPage;
import com.epam.tc.hw5.pages.UserTablePage;
import com.epam.tc.hw5.utils.TestContext;
import org.openqa.selenium.WebDriver;

public abstract class AbstractStep {

    protected HomePage homePage;
    protected LoginPanelPage loginPage;
    protected DifferentElementsPage differentElementsPage;
    protected UserTablePage userTablePage;

    public AbstractStep() {
        WebDriver driver = TestContext.getInstance().getTestObject("web_driver");

        homePage = new HomePage(driver);
        loginPage = new LoginPanelPage(driver);
        differentElementsPage = new DifferentElementsPage(driver);
        userTablePage = new UserTablePage(driver);
    }
}
