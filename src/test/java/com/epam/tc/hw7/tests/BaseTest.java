package com.epam.tc.hw7.tests;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.tc.hw7.dataproviders.UserData.DEFAULT_USER;
import static com.epam.tc.hw7.site.JdiTestingSite.homePage;
import static com.epam.tc.hw7.site.pages.HomePage.loginForm;
import static com.epam.tc.hw7.site.pages.HomePage.userIcon;

import com.epam.tc.hw7.site.JdiTestingSite;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class BaseTest {

    @BeforeSuite(alwaysRun = true)
    static void setUp() {
        killAllSeleniumDrivers();
        openSite(JdiTestingSite.class);

        // Login on JDI site as User
        homePage.open();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @AfterSuite(alwaysRun = true)
    static void teardown() {
        killAllSeleniumDrivers();
    }
}
