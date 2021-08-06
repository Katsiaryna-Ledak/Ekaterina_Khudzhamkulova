package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise2 {

    private String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private String userName = "Roman";
    private String userPswd = "Jdi1234";
    private String browserTitle = "Home Page";
    private String userLogin = "ROMAN IOVLEV";

    private WebDriver webDriver;

    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void ex2EpamPageTest() {

        // Open test site by URL
        webDriver.navigate().to(siteURL);

        // Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(browserTitle);

        // Perform login
        webDriver.findElement(By.className("profile-photo")).click();
        webDriver.findElement(By.id("name")).sendKeys(userName);
        webDriver.findElement(By.id("password")).sendKeys(userPswd);
        webDriver.findElement(By.id("login-button")).click();

        // Assert User name in the left-top side of screen that user is loggined
        Assertions.assertThat(webDriver.findElement(By.xpath("//span[text()='Roman Iovlev']")).equals(userLogin));
        // Assert Username is loggined (is displayed)
        Assertions.assertThat(webDriver.findElement(By.xpath("//span[text()='Roman Iovlev']")).isDisplayed());

        // Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']")).click();
        webDriver.findElement(By.xpath("//a[@href='different-elements.html']")).click();

        // Select checkboxes Water and Wind
        webDriver.findElement(By.xpath("//label[@class='label-checkbox'][1]")).click();
        webDriver.findElement(By.xpath("//label[@class='label-checkbox'][3]")).click();

        // Select radio Selen
        webDriver.findElement(By.xpath("(//div[@class='checkbox-row']//input[@name='metal'])[4]")).click();

        // Select in dropdown
        webDriver.findElement(By.xpath("//select[@class='uui-form-element']/option[text()='Yellow']")).click();

        // Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        WebElement logLineForWind = webDriver.findElement(By.cssSelector("ul.panel-body-list.logs > li:nth-child(3)"));
        WebElement logLineForWater = webDriver.findElement(By.cssSelector("ul.panel-body-list.logs > li:nth-child(4)"));

        Assertions.assertThat(logLineForWind.getText().contains("Wind: condition changed to true"));
        Assertions.assertThat(logLineForWater.getText().contains("Water: condition changed to true"));

        // Assert that
        // for radio button there is a log row and value is corresponded to the status of radio button

        WebElement logLineForMetal = webDriver.findElement(By.cssSelector("ul.panel-body-list.logs > li:nth-child(2)"));
        Assertions.assertThat(logLineForMetal.getText().contains("metal: value changed to Selen"));

        // Assert that
        // for dropdown there is a log row and value is corresponded to the selected value

        WebElement logLineForColor = webDriver.findElement(By.cssSelector("ul.panel-body-list.logs > li:nth-child(1)"));
        Assertions.assertThat(logLineForMetal.getText().contains("Colors: value changed to Yellow"));

        // Close Browser
    }

    @AfterClass()
    public void tearDown() {
        webDriver.close();
    }
}
