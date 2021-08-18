package com.epam.tc.hw5.components;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class AbstractComponent {

    protected WebDriver webDriver;
    protected WebDriverWait wait;
    protected Actions actions;

    protected AbstractComponent(WebDriver driver) {
        this.webDriver = driver;
        wait = new WebDriverWait(driver, 10L);
        PageFactory.initElements(driver, this);
        actions = new Actions(driver);
    }
}
