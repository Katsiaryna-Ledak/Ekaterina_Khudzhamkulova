package com.epam.tc.hw3.testcases;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class InitializationTest {

    protected String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    protected String browserTitle = "Home Page";
    protected String userName = "Roman";
    protected String userPswd = "Jdi1234";
    protected String userLogin = "ROMAN IOVLEV";
    protected List<String> navBarNames = Arrays.asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");
    protected List<String> benefitTexts = Arrays.asList("To include good practices\n"
        + "and ideas from successful\n"
        + "EPAM project", "To be flexible and\n"
        + "customizable", "To be multiplatform", "Already have good base\n"
        + "(about 20 internal and\n"
        + "some external projects),\n"
        + "wish to get more…");
    protected List<String> leftSideBarMenuItems = Arrays
        .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
    protected List<String> logTextItems = Arrays.asList("Colors: value changed to Yellow",
        "metal: value changed to Selen", "Wind: condition changed to true", "Water: condition changed to true");

    WebDriver webDriver;

    @BeforeMethod
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterMethod
    public void tearDown() {
        if (webDriver != null) {
            webDriver.quit();
        }
    }
}
