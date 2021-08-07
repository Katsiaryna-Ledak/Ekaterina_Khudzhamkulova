package com.epam.tc.hw3.testCases;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class HomePageTC {
    private String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";

    WebDriver webDriver;


    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
    }


    @Test
    public void ex1HW3EpamPageTest() {

        // Open test site by URL
        webDriver.navigate().to(siteURL);
    }
}
