package com.epam.tc.hw4.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends AbstractPage {

    protected static final String SITE_URL = "https://jdi-testing.github.io/jdi-light/index.html";

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

    public HomePage(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void openHomePage() {
        webDriver.navigate().to(SITE_URL);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public List<String> getNavBarItemsNames() {
        List<String> navBarItemsList = new ArrayList<>();
        for (WebElement navBarItem : navBarElements) {
            navBarItemsList.add(navBarItem.getText());
        }
        return navBarItemsList;
    }

    public List<WebElement> getIndexImages() {
        return indexImagesList;
    }

    public List<String> textUnderIndexImages() {
        List<String> textUnderImagesList = new ArrayList<>();
        for (WebElement textUnderImage : textUnderBenefitImagesList) {
            textUnderImagesList.add(textUnderImage.getText());
        }
        return textUnderImagesList;
    }

    public WebElement getFrameElement() {
        return frame;
    }

    public List<String> getLeftSideBarItems() {
        List<String> leftSideBarItemsList = new ArrayList<>();
        for (WebElement leftBarItem : leftSideBarItems) {
            leftSideBarItemsList.add(leftBarItem.getText());
        }
        return leftSideBarItemsList;
    }

    public void clickOnServiceDiffElementsHead() {
        headMenuElement.get(2).click();
        getServiceDiffElementsHeadMenu.click();
    }
}
