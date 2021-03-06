package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPanelComponent extends AbstractPage {

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

    public LoginPanelComponent(WebDriver webDriver) {
        super(webDriver);
        PageFactory.initElements(webDriver, this);
    }

    public void performLogin(String userLoginName, String userPassword) {
        openLoginField.click();
        loginInput.click();
        loginInput.sendKeys(userLoginName);
        passwordInput.click();
        passwordInput.sendKeys(userPassword);
        loginButton.click();
    }

    public String getLoggedInUserName() {
        return userName.getText();
    }
}
