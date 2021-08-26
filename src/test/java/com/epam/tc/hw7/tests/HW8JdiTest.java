package com.epam.tc.hw7.tests;

import static com.epam.tc.hw7.site.JdiTestingSite.metalsAndColorsPage;
import static com.epam.tc.hw7.site.pages.HomePage.metalsColorsButton;
import static com.epam.tc.hw7.site.pages.MetalsAndColorsPage.metalsColorsForm;

import com.epam.tc.hw7.dataproviders.MetalsColorsDataProvider;
import com.epam.tc.hw7.entities.MetalsColorsModel;
import org.testng.annotations.Test;

public class HW8JdiTest extends BaseTest {

    @Test(dataProvider = "metalsColorsObjects", dataProviderClass = MetalsColorsDataProvider.class)
    public void metalsAndColorsPageTest(MetalsColorsModel metalsColorsModel) {

        // Open Metals & Colors page by Header menu
        metalsColorsButton.click();
        metalsAndColorsPage.shouldBeOpened();

        //Fill form Metals & Colors by data below (json)
        metalsColorsForm.fill(metalsColorsModel);

        // Submit form Metals & Colors
        metalsColorsForm.submit();

        // Result sections should contain data below (look .xlsx table with task to HW7)
        metalsColorsForm.verifyIfResultsAreCorrect(metalsColorsModel);
    }
}

