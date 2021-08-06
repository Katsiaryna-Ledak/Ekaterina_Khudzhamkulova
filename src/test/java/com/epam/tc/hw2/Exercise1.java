package com.epam.tc.hw2;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Exercise1 {

    private String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private String userName = "Roman";
    private String userPswd = "Jdi1234";
    private String browserTitle = "Home Page";
    private String userLogin = "ROMAN IOVLEV";

    private WebDriver webDriver;
    private WebElement webElement;


    @BeforeClass
    public void setupClass() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().window().maximize();
        webDriver.manage().timeouts()
                 .implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Test
    public void ex1EpamPageTest() {

        // Open test site by URL
        webDriver.navigate().to(siteURL);

        // Assert Browser title
        Assertions.assertThat(webDriver.getTitle()).isEqualTo(browserTitle);

        // Perform login
        webDriver.findElement(By.className("profile-photo")).click();
        webDriver.findElement(By.id("name")).sendKeys(userName);
        webDriver.findElement(By.id("password")).sendKeys(userPswd);
        webDriver.findElement(By.id("login-button")).click();

        // Assert Username is loggined (equals to expected result)
        Assertions.assertThat(webDriver.findElement(By.xpath("//span[text()='Roman Iovlev']")).equals(userLogin));
        // Assert Username is loggined (is displayed)
        Assertions.assertThat(webDriver.findElement(By.xpath("//span[text()='Roman Iovlev']")).isDisplayed());

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        // 1. HOME
        String homeMenu = webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='index.html']")).getText();
        Assertions.assertThat(homeMenu.contains("HOME"));
        Assertions.assertThat(webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='index.html']")).isDisplayed());

        // 2. CONTACT FORM
        String contactsMenu = webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='contacts.html']")).getText();
        Assertions.assertThat(contactsMenu.contains("CONTACT FORM"));
        Assertions.assertThat(webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='contacts.html']")).isDisplayed());

        // 3. SERVICE
        String serviceMenu = webDriver
            .findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"))
            .getText();
        Assertions.assertThat(serviceMenu.contains("SERVICE"));
        Assertions.assertThat(webDriver
            .findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@class='dropdown-toggle']"))
            .isDisplayed());

        // 4. METALS & COLORS
        String metalsAndColorsMenu = webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='metals-colors.html']")).getText();
        Assertions.assertThat(serviceMenu.contains("METALS & COLORS"));
        Assertions.assertThat(webDriver.findElement(By.xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']//a[@href='metals-colors.html']")).isDisplayed());

        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexImagesList = webDriver.findElements(By.className("benefit-icon"));
        int expectedIndexImagesNumber = 4;
        Assertions.assertThat(indexImagesList.size()).isEqualTo(expectedIndexImagesNumber);
        for (WebElement image : indexImagesList) {
            Assertions.assertThat(image.isDisplayed());
        }

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> indexTextUnderImagesList = webDriver.findElements(By.className("benefit-txt"));
        int expectedNumberOfPhrases = 4;
        Assertions.assertThat(indexTextUnderImagesList.size()).isEqualTo(4);

        String expectedPhrase1 = "To include good practices\n"
            + "and ideas from successful\n"
            + "EPAM project";
        String phrase1Actual = webDriver.findElement(By.xpath("(//span[@class='benefit-txt'])[1]")).getText();
        Assertions.assertThat(phrase1Actual.equals(expectedPhrase1));

        String expectedPhrase2 = "To be flexible and\n"
            + "customizable";
        String phrase2Actual = webDriver.findElement(By.xpath("(//span[@class='benefit-txt'])[2]")).getText();
        Assertions.assertThat(phrase2Actual.equals(expectedPhrase2));

        String expectedPhrase3 = "To be multiplatform";
        String phrase3Actual = webDriver.findElement(By.xpath("(//span[@class='benefit-txt'])[3]")).getText();
        Assertions.assertThat(phrase3Actual.equals(expectedPhrase3));

        String expectedPhrase4 = "Already have good base\n"
            + "(about 20 internal and\n"
            + "some external projects),\n"
            + "wish to get more…";
        String phrase4Actual = webDriver.findElement(By.xpath("(//span[@class='benefit-txt'])[4]")).getText();
        Assertions.assertThat(phrase4Actual.equals(expectedPhrase4));

        // Assert that there is the iframe with “Frame Button” exist
        Assertions.assertThat(webDriver.findElement(By.id("frame")).isEnabled());
        Assertions.assertThat(webDriver.findElement(By.id("frame")).isDisplayed());

        // Switch to the iframe and check that there is “Frame Button” in the iframe
        webElement = webDriver.findElement(By.xpath("//iframe[@id='frame']"));
        String startWindowPage = webDriver.getWindowHandle();
        webDriver.switchTo().frame(webElement);
        Assertions.assertThat(webDriver.findElement(By.id("frame-button")).isEnabled());

        // Switch to original window back
        webDriver.switchTo().window(startWindowPage);

        // Assert that there are 5 items in the Left Section are displayed and they have proper text
        List<String> expectedSideBarMenuList = Arrays
            .asList("Home", "Contact form", "Service", "Metals & Colors", "Elements packs");
        List<WebElement> actualSideBarMenuList = webDriver
            .findElements(By.xpath("//ul[contains (@class, 'left')]/li/a"));
        Assertions.assertThat(actualSideBarMenuList.size()).isEqualTo(expectedSideBarMenuList.size());
        for (int i = 0; i < actualSideBarMenuList.size(); i++) {
            Assertions.assertThat(actualSideBarMenuList.get(i).isDisplayed());
            Assertions.assertThat(actualSideBarMenuList.get(i).getText()).isEqualTo(expectedSideBarMenuList.get(i));
        }

        // Close Browser

    }

    @AfterClass()
    public void tearDown() {
        webDriver.close();
    }
}
