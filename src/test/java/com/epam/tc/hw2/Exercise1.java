package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise1 {

    private WebDriver webDriver;
    private String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private String userName = "Roman";
    private String userPswd = "Jdi1234";
    private String browserTitle = "Home Page";
    private String userLogin = "ROMAN IOVLEV";


    @BeforeClass
    public static void setupClass() {
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void ex1EpamPageTest() {

        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
        // Open test site by URL
        webDriver.navigate().to(siteURL);

        // Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(browserTitle);

        // Perform login
        webDriver.findElement(By.className("profile-photo")).click();
        webDriver.findElement(By.id("name")).sendKeys(userName);
        webDriver.findElement(By.id("password")).sendKeys(userPswd);
        webDriver.findElement(By.id("login-button")).click();


    }

}
