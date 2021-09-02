package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.init.PageFactory.initSite;
import static com.epam.tc.hw7.dataproviders.UserData.DEFAULT_USER;
import static com.epam.tc.hw7.site.JdiTestingSite.homePage;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;
import static com.epam.tc.hw7.site.pages.HomePage.userName;

import com.epam.tc.hw7.site.JdiTestingSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        initSite(JdiTestingSite.class);

        // Login on JDI site as User
        homePage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);

        // Assert if Login in correct
        userName.is().text(DEFAULT_USER.fullName);
        homePage.checkOpened();
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        homePage.logout();
        killAllSeleniumDrivers();
    }
}
