package com.epam.tc.hw5.cucumber;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
    plugin = {"io.qameta.allure.cucumber6jvm.AllureCucumber6Jvm"},
    features = {"src/test/resources/com/epam/tc/epam/cucumber/Exercise1/homePageCheckOfElements.feature",
        "src/test/resources/com/epam/tc/epam/cucumber/Exercise2/userTablePageCheckInfo.feature",
        "src/test/resources/com/epam/tc/epam/cucumber/Exercise3/userTableVIPCheckInfo.feature"})
public class RunAcceptanceTest extends AbstractTestNGCucumberTests {
}
