package com.epam.tc.hw4.listeners;

import com.epam.tc.hw4.util.AttachmentUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ScreenshotListener implements ITestListener {

    @Override
    public void onTestFailure(ITestResult itestResult) {
        Object driver = itestResult.getTestContext().getAttribute("driver");
        if (driver != null) {
            AttachmentUtils.makeScreenshotAttachment("Failure screenshot",
                ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES));
        }
    }

}
