package com.epam.tc.hw4.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {

    protected WebDriver webDriver;

    public AbstractPage(WebDriver driver) {
        this.webDriver = driver;
    }
}
