package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.AbstractComponent;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage extends AbstractComponent {

    private static final String SITE_URL = "https://jdi-testing.github.io/jdi-light/";
    protected LoginPanelPage loginPanel;

    protected AbstractPage(WebDriver webDriver) {
        super(webDriver);
        loginPanel = new LoginPanelPage(webDriver);
    }

    protected void openHomePage(String url) {
        webDriver.navigate().to(SITE_URL + url);
    }
}

