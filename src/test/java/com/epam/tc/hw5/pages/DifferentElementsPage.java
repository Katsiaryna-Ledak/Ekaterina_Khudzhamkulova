package com.epam.tc.hw5.pages;

import com.epam.tc.hw5.components.AbstractComponent;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DifferentElementsPage extends AbstractPage {

    public DifferentElementsPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    // check boxes
    @FindBy(css = "input[type=checkbox]")
    private List<WebElement> getCheckboxes;

    // radio buttons
    @FindBy(className = "label-radio")
    private List<WebElement> radioButtons;

    // dropdown with Colors
    @FindBy(css = "option")
    private List<WebElement> colorsDropdown;
    @FindBy(xpath = "//select[@class='uui-form-element']/option[text()='Yellow']")
    private WebElement yellowColorDropdown;

    // log panel elements
    @FindBy(css = "ul.panel-body-list.logs > li")
    private List<WebElement> logElementList;

    public void openHomePage() {
        openHomePage("different-elements.html");
    }

    public void selectWaterCheckBox() {
        getCheckboxes.get(0).click();
    }

    public void selectWindCheckbox() {
        getCheckboxes.get(2).click();
    }

    public void selectSelenRadio() {
        radioButtons.get(3).click();
    }

    public void selectYellowInDropdown() {
        colorsDropdown.get(3).click();
        yellowColorDropdown.click();
    }

    public List<String> getLogList() {
        List<String> logList = new ArrayList<>();
        for (WebElement logItem : logElementList) {
            logList.add(logItem.getText());
        }
        return logList;
    }
}
