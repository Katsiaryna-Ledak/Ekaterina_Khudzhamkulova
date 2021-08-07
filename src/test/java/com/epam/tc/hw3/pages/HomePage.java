package com.epam.tc.hw3.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {

    public HomePage(WebDriver webDriver) {
        PageFactory.initElements(webDriver, this);
    }

    WebDriver webDriver;

    // login web elements
    @FindBy(id = "user-icon")
    private WebElement openLoginField;
    @FindBy(id = "name")
    private WebElement loginInput;
    @FindBy(id = "password")
    private WebElement passwordInput;
    @FindBy(id = "login-button")
    private WebElement loginButton;
    @FindBy(id = "user-name")
    private WebElement userName;

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


    public void performLogin(String userLoginName, String userPassword) {
        openLoginField.click();
        loginInput.click();;
        loginInput.sendKeys(userLoginName);
        passwordInput.click();
        passwordInput.sendKeys(userPassword);
        loginButton.click();
    }

    public String getLoggedInUserName(){
        return userName.getText();
    }

    public List<String> getNavBarItemsNames(){
        List<String> navBarItemsList = new ArrayList<>();
        for (WebElement navBarItem : navBarElements) {
            navBarItemsList.add(navBarItem.getText());
        }
        return navBarItemsList;
    }

    public List<WebElement> getIndexImages(){
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

    public WebElement getFrameButton() {
        return frameButton;
    }

    public List<String> getLeftSideBarItems(){
        List<String> leftSideBarItemsList = new ArrayList<>();
        for (WebElement leftBarItem : leftSideBarItems) {
            leftSideBarItemsList.add(leftBarItem.getText());
        }
        return leftSideBarItemsList;
    }

}
