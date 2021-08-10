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

    private static final String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String userName = "Roman";
    private static final String userPassword = "Jdi1234";
    private static final String browserTitle = "Home Page";
    private static final String userLogin = "ROMAN IOVLEV";

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
        webDriver.findElement(By.id("password")).sendKeys(userPassword);
        webDriver.findElement(By.id("login-button")).click();

        // Assert User name in the left-top side of screen that user is loggined
        String userNameXPath = "//span[text()='Roman Iovlev']";
        Assertions.assertThat(webDriver.findElement(By.xpath(userNameXPath)).equals(userLogin));
        // Assert Username is loggined (is displayed)
        Assertions.assertThat(webDriver.findElement(By.xpath(userNameXPath)).isDisplayed());

        // Open through the header menu Service -> Different Elements Page
        webDriver.findElement(By.className("dropdown-toggle")).click();
        webDriver.findElement(By.xpath("//a[text() = 'Different elements']")).click();

        // Select checkboxes Water and Wind
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Water')]]/input")).click();
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Wind')]]/input")).click();

        // Select radio Selen
        webDriver.findElement(By.xpath("//label[text()[contains(.,'Selen')]]/input")).click();

        // Select in dropdown
        webDriver.findElement(By.cssSelector("select.uui-form-element")).click();
        webDriver.findElement(By.xpath("//option[text()='Yellow']")).click();

        // Assert that
        // for each checkbox there is an individual log row and value is corresponded to the status of checkbox

        WebElement logLineForWind = webDriver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Wind: condition changed to true')]"));
        WebElement logLineForWater = webDriver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Water: condition changed to true')]"));

        Assertions.assertThat(logLineForWind.getText().contains("Wind: condition changed to true"));
        Assertions.assertThat(logLineForWater.getText().contains("Water: condition changed to true"));

        // Assert that
        // for radio button there is a log row and value is corresponded to the status of radio button

        WebElement logLineForMetal = webDriver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'metal: value changed to  Selen')]"));
        Assertions.assertThat(logLineForMetal.getText().contains("metal: value changed to Selen"));

        // Assert that
        // for dropdown there is a log row and value is corresponded to the selected value

        WebElement logLineForColor = webDriver.findElement(By
            .xpath("//ul[@class='panel-body-list logs']/li[contains(text(),'Colors: value changed to Yellow')]"));
        Assertions.assertThat(logLineForMetal.getText().contains("Colors: value changed to Yellow"));

        // Close Browser
    }

    @AfterClass()
    public void tearDown() {
        webDriver.close();
    }
}
