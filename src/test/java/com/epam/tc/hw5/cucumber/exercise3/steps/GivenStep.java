package com.epam.tc.hw5.cucumber.exercise3.steps;

import com.epam.tc.hw5.utils.PropertiesFileReader;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;

public class GivenStep extends AbstractStep {

    @Given("I open JDI GitHub site")
    public void openIndexPage() {
        homePage.openHomePage();
    }

    @And("I login as user 'Roman Iovlev'")
    public void login() {
        PropertiesFileReader fileReader = new PropertiesFileReader();
        String login = fileReader.getProperties("userName");
        String password = fileReader.getProperties("userPassword");
        loginPage.performLogin(login, password);
    }

    @And("I click on 'Service' button in Header")
    public void clickOnDiffElementsOnServiceHead() {
        homePage.clickOnServiceDiffElementsHead();
    }

    @And("I click on 'User Table' button in Service dropdown")
    public void clickOnUserTableOnServiceHead() {
        homePage.clickOnServiceUserTable();
    }
}
