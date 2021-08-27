package com.epam.tc.hw6.testcases;

import com.epam.tc.hw6.util.driver.WebDriverSingleton;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InitializationTest {

    protected static String SITE_URL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected static String BROWSER_TITLE = "Home Page";
    protected static List<String> NAV_BAR_NAMES = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected static List<String> BENEFIT_TEXTS = Arrays.asList("To include good practices\n"
        + "and ideas from successful\n"
        + "EPAM project", "To be flexible and\n"
        + "customizable", "To be multiplatform", "Already have good base\n"
        + "(about 20 internal and\n"
        + "some external projects),\n"
        + "wish to get more…");
    protected static List<String> LEFT_SIDE_BAR_MENU_ITEMS = Arrays
        .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    protected static List<String> LOG_TEXT_ITEMS = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");

    protected WebDriver webDriver;

    @BeforeMethod
    public void setupClass(ITestContext context) {
        webDriver = WebDriverSingleton.getDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        WebDriverSingleton.closeDriver();
    }
}
