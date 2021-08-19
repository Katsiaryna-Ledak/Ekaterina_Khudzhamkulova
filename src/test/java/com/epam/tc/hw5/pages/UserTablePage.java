package com.epam.tc.hw5.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UserTablePage extends AbstractPage {

    @FindBy(css = "#user-table tbody tr td select")
    private List<WebElement> typeDropdownList;

    @FindBy(css = "#user-table a")
    private List<WebElement> userNameList;

    @FindBy(css = "#user-table span")
    public List<WebElement> userDescriptionUnderImagesList;

    @FindBy(css = "#user-table input")
    public List<WebElement> userCheckboxesList;

    @FindBy(css = "#user-table>tbody>tr>td:nth-child(1)")
    private List<WebElement> userNumberList;

    @FindBy(css = "tbody tr:first-child option")
    private List<WebElement> dropdownValuesForUserRoman;

    public UserTablePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    public String getPageTitle() {
        return webDriver.getTitle();
    }

    public List<String> getUserTypeDropdownsList() {
        List<String> actualDropdownsList = new ArrayList<>();
        for (WebElement item : typeDropdownList) {
            actualDropdownsList.add(item.getText());
        }
        return actualDropdownsList;
    }

    public List<String> getUserNamesList() {
        List<String> actualUserNamesList = new ArrayList<>();
        for (WebElement item : userNameList) {
            actualUserNamesList.add(item.getText());
        }
        return actualUserNamesList;
    }

    public List<String> getUserDescList() {
        List<String> actualUserDescList = new ArrayList<>();
        for (WebElement item : userDescriptionUnderImagesList) {
            actualUserDescList.add(item.getText());
        }
        return actualUserDescList;
    }

    public List<String> getUserCheckboxesList() {
        List<String> actualUserCheckboxesList = new ArrayList<>();
        for (WebElement item : userCheckboxesList) {
            actualUserCheckboxesList.add(item.getText());
        }
        return actualUserCheckboxesList;
    }

    public List<String> getUserNumberList() {
        List<String> actualUserNumberList = new ArrayList<>();
        for (WebElement item : userNumberList) {
            actualUserNumberList.add(item.getText());
        }
        return actualUserNumberList;
    }

    public List<String> getDropdownValuesForUserRoman() {
        List<String> actualValuesForRomanList = new ArrayList<>();
        for (WebElement item : dropdownValuesForUserRoman) {
            actualValuesForRomanList.add(item.getText());
        }
        return actualValuesForRomanList;
    }
}
