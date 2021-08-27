package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class AbstractPage {

    protected WebDriver webDriver;

    public AbstractPage(WebDriver driver) {
        this.webDriver = driver;
        PageFactory.initElements(webDriver, this);
    }

}
