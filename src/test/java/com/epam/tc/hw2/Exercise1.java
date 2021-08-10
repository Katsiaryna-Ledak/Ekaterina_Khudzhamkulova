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

    private static final String siteURL = "https://jdi-testing.github.io/jdi-light/index.html";
    private static final String userName = "Roman";
    private static final String userPassword = "Jdi1234";
    private static final String browserTitle = "Home Page";
    private static final String userLogin = "ROMAN IOVLEV";
    private static final List<String> expectedBenefitTexts = Arrays.asList("To include good practices\n"
        + "and ideas from successful\n"
        + "EPAM project", "To be flexible and\n"
        + "customizable", "To be multiplatform", "Already have good base\n"
        + "(about 20 internal and\n"
        + "some external projects),\n"
        + "wish to get more…");

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
        webDriver.findElement(By.id("password")).sendKeys(userPassword);
        webDriver.findElement(By.id("login-button")).click();

        // Assert Username is loggined
        String userNameXPath = "//span[text()='Roman Iovlev']";
        Assertions.assertThat(webDriver.findElement(By.xpath(userNameXPath)).equals(userLogin));
        // Assert Username is loggined (is displayed)
        Assertions.assertThat(webDriver.findElement(By.xpath(userNameXPath)).isDisplayed());

        // Assert that there are 4 items on the header section are displayed and they have proper texts
        List<WebElement> navBarElements = webDriver.findElements(By
            .xpath("//ul[@class='uui-navigation nav navbar-nav m-l8']"));
        Integer expectedNavBarElementsSize = 4;
        Integer actualNavBarElementsSize = navBarElements.size();
        Assertions.assertThat(actualNavBarElementsSize.equals(expectedNavBarElementsSize));

        List<String> expectedNavBarElementsItems = Arrays
            .asList("HOME", "CONTACT FORM", "SERVICE", "METALS & COLORS");

        for (WebElement item : navBarElements) {
            Assertions.assertThat(item.isDisplayed());
        }

        for (int i = 0; i < navBarElements.size(); i++) {
            Assertions.assertThat((expectedNavBarElementsItems.get(i)).equals(navBarElements.get(i)));
        }


        // Assert that there are 4 images on the Index Page and they are displayed
        List<WebElement> indexImagesList = webDriver.findElements(By.className("benefit-icon"));
        int expectedIndexImagesNumber = 4;
        Assertions.assertThat(indexImagesList.size()).isEqualTo(expectedIndexImagesNumber);
        for (WebElement image : indexImagesList) {
            Assertions.assertThat(image.isDisplayed());
        }

        // Assert that there are 4 texts on the Index Page under icons and they have proper text
        List<WebElement> indexTextUnderImagesList = webDriver.findElements(By.className("benefit-txt"));
        int expectedNumberOfPhrases = expectedBenefitTexts.size();
        Assertions.assertThat(indexTextUnderImagesList.size()).isEqualTo(expectedNumberOfPhrases);

        for (int i = 0; i < indexTextUnderImagesList.size(); i++) {
            Assertions.assertThat((indexTextUnderImagesList.get(i)).equals(expectedBenefitTexts.get(i)));
        }

        // Assert that there is the iframe with “Frame Button” exist
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
