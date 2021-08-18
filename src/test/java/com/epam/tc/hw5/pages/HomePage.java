package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {
    public WebDriver webDriver;

    public HomePage(WebDriver driver) {
        super(driver);
    }

    // header section web elements
    @FindBy(xpath = "//ul[@class='uui-navigation nav navbar-nav m-l8']")
    private List<WebElement> navBarElements;

    // benefit icons
    @FindBy(className = "benefit-icon")
    private List<WebElement> indexImagesList;

    // text under benefit icons
    @FindBy(className = "benefit-txt")
    private List<WebElement> textUnderBenefitImagesList;

    // frame elements
    @FindBy(id = "frame")
    private WebElement frame;
    @FindBy(id = "frame-button")
    private WebElement frameButton;

    // left side-bar menu elements
    @FindBy(className = "sidebar-menu left")
    private List<WebElement> leftSideBarItems;

    // head menu elements
    @FindBy(xpath = "//ul[contains(@class, 'm-l8')]/li/a")
    private List<WebElement> headMenuElement;
    @FindBy(xpath = "//a[text() = 'Different elements']")
    private WebElement getServiceDiffElementsHeadMenu;

    protected static String SITE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

    public void openHomePage() {
        openHomePage("index.html");
    }

    public void clickOnServiceDiffElementsHead() {
        headMenuElement.get(2).click();
        getServiceDiffElementsHeadMenu.click();
    }
}
